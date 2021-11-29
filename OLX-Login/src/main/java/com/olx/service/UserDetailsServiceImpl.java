package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.olx.entity.OlxLoginEntity;
import com.olx.repo.OlxLoginRepo;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	OlxLoginRepo olxLoginRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<OlxLoginEntity> userEntityList =  olxLoginRepo.findByUsername(username);
		if(userEntityList.size() == 0) {
			throw new UsernameNotFoundException(username);
		}
		
		OlxLoginEntity userEntity = userEntityList.get(0);
		List<GrantedAuthority> autorities =  new ArrayList<GrantedAuthority>();
		autorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));
		
		User user = new User(userEntity.getUsername(), passwordEncoder.encode(userEntity.getPassword()),autorities);
		
		return user;
	}

}
