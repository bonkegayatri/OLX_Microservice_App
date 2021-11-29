package com.olx.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.olx.dto.Advertise;

public interface AdvertisementService {

	public Collection<Advertise> searchAdvertisementByFilter(
			String title,
			Double price,
			String status,
			Date createdDate);
	
	public List<Advertise> searchAdvertisementBySearchText(@RequestParam("searchText") String searchText);
	
	public Boolean deleteAdvertisementById(@PathVariable("advertiseId") int stockId,
			@RequestHeader("auth-token") String auth_token);
	
	public Advertise getAdvertisementById(@PathVariable("advertiseId") int advertiseId,
			@RequestHeader("auth-token") String auth_token) ;
	
	public Collection<Advertise> getAllAdvertisement();
	
	public Advertise updateAdvertiseByID(@PathVariable("id") int id, @RequestBody Advertise newAdvertise,
			@RequestHeader("auth-token") String auth_token);
	
	public Advertise createNewAdvertise(@RequestBody Advertise advertise, @RequestHeader("Authorization") String auth_token);
	
}
