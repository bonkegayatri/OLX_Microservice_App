package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.AuthenticationRequest;
import com.olx.dto.OlxLoginDetails;
import com.olx.dto.UserToken;
import com.olx.security.JwtUtil;
import com.olx.service.OlxLoginService;
import com.olx.service.TokenService;


@RestController
@RequestMapping("olx/auth")
public class LoginController {

	@Autowired
	AuthenticationManager autheticationManager;
	
	@Autowired
	@Qualifier("JPA_SERVICE")
	OlxLoginService olxLoginService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	@Qualifier("MONGO_SERVICE")
	TokenService tokenService;

	@Autowired
	UserDetailsService userDetailsService;
	
	private int LastTokenId = 1;

	@DeleteMapping(value = "/user/logout")
	public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String authorization) {
		LastTokenId++;
		tokenService.saveToken(new UserToken(LastTokenId,authorization));
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/token", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<UserToken> getAllToken(){
		return tokenService.getAllToken();
	}
	
	@PostMapping(value="/user/authenticate", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
		
		try {
			this.autheticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
					authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException ex) {
			return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String jwtToken  = jwtUtil.generateToken(userdetails);
		return new ResponseEntity(jwtToken,HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public String hellAll() {
		return "Hello ALl";
	}
	
	@GetMapping(value = "/user/validate/token")
	public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authtoken) {
		boolean isTokenValid = false;
		try {
		String token = authtoken.replace("Bearer ", "");
		System.out.print(token);
		String username = jwtUtil.extractUsername(token);
		UserDetails userdetails = userDetailsService.loadUserByUsername(username);
	    isTokenValid =  jwtUtil.validateToken(token, userdetails);
		}
		catch (Exception ex) {
			return new ResponseEntity<Boolean>(isTokenValid,HttpStatus.BAD_REQUEST);
		}
		
		List<UserToken> tokenList = tokenService.getAllToken();
		boolean isTokenBlocked = false;
		
		for(UserToken token: tokenList) {
			if(token.getToken().equals(authtoken)) {
				System.out.println("token :" + token.getToken());
				isTokenBlocked = true;
			}else {
				isTokenBlocked = false;
			}
			System.out.println("isTokenBlocked :" + isTokenBlocked);
		}
		if(isTokenBlocked) {
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
			
		} else {
	        return new ResponseEntity<Boolean>(isTokenValid,HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/admin")
	public String hellAdmin() {
		return "Hello Admin";
	}
	
	@PostMapping(value="/login", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public OlxLoginDetails createNewUser(@RequestBody OlxLoginDetails olxLoginDetails){
		
		return olxLoginService.createNewOlxLoginDetails(olxLoginDetails);	
	}
	
	@GetMapping(value="/login", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<OlxLoginDetails> getAllOlxLoginDetails(){
		return olxLoginService.getAllOlxLoginDetails();
	}
	
}
