package com.olx.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MasterDataDelegateImpl implements MasterDataDelegate {

	@Autowired
	RestTemplate advrestTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate getAdvRestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	@CircuitBreaker(name="CATEGORY-CIRCUIT-BREAKER", fallbackMethod = "fallbackGetAllCategories")
	public List<Map> getAllCategories() {
		List list = this.advrestTemplate.getForObject("http://API-GATEWAY/olx/masterdata/advertise/category", List.class);
		return list;
	}

	@Override
	@CircuitBreaker(name="STATUS_CIRCUIT_BREAKER", fallbackMethod = "fallbackGetAllStatus")
	public List<Map> getAllStatus() {
		List list = this.advrestTemplate.getForObject("http://API-GATEWAY/olx/masterdata/advertise/status", List.class);
		return list;
	}
	
	public List<Map> fallbackGetAllCategories(Throwable ex){
		System.out.print("Masterata call failed :"+ ex);
		return null;
	}
	
	public List<Map> fallbackGetAllStatus(Throwable ex){
		System.out.print("Masterata call failed :"+ ex);
		return null;
	}

	
}
