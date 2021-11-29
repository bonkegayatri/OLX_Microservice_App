package com.olx.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoginDelegateImpl implements LoginDelegate{

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	@CircuitBreaker(name="AUTH_CIRCUIT_BREAKER", fallbackMethod = "fallbackAuthentication")
	public boolean validateToken(String auth_token) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", auth_token);		
		ResponseEntity<Boolean> response = restTemplate.exchange("http://API-GATEWAY/olx/auth/user/validate/token", HttpMethod.GET, new HttpEntity(headers), Boolean.class);
		return response.getBody();

	}
	
	public boolean fallbackAuthentication(String auth_token, Throwable ex){
		System.out.print("Masterata call failed :"+ ex);
		return false;
	}

}
