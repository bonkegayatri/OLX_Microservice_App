package com.olx.controller;

import java.util.Collection;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Advertise;
import com.olx.service.AdvertisementService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("olx/advertise")
public class AdvertiseController {

	@Autowired
	AdvertisementService advertisementService;
	
	@GetMapping(value = "/advertise/filtercriteria", produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Search Advertisement")
	public Collection<Advertise> searchAdvertisementByFilter(
	@RequestParam(value = "title", required = false) String title,
	@RequestParam(value = "price", required = false) Double price,
	@RequestParam(value = "status", required = false) String status,
	@RequestParam(value = "createdDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdDate) {

	 return advertisementService.searchAdvertisementByFilter(title, price, status, createdDate);

	}

	@GetMapping(value = "/user/advertise", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Search Advertisement")
	public List<Advertise> searchAdvertisementByFilerCriteria(@RequestParam("searchText") String searchText) {
		return advertisementService.searchAdvertisementBySearchText(searchText);
		
	}

	@DeleteMapping(value = "/user/advertise/{advertiseId}")
	@ApiOperation(value = "Delete Advertisement By Id")
	public Boolean deleteAdvertisementById(@PathVariable("advertiseId") int stockId,
			@RequestHeader("Authorization") String auth_token) {
		return advertisementService.deleteAdvertisementById(stockId, auth_token);
	}

	@GetMapping(value = "/user/advertise/{advertiseId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Get Advertisement By Id")
	public Advertise getAdvertisementById(@PathVariable("advertiseId") int advertiseId,
			@RequestHeader("Authorization") String auth_token) {
		return advertisementService.getAdvertisementById(advertiseId, auth_token);
	}

	@GetMapping(value = "/user/advertises", produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Get All Advertisement")
	public @ResponseBody Collection<Advertise> getAllAdvertisement() {
		return advertisementService.getAllAdvertisement();
	}

	@PutMapping(value = "/updateadvertise/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Update Advertisement")
	public Advertise updateAdvertiseByID(@PathVariable("id") int id, @RequestBody Advertise newAdvertise,
			@RequestHeader("Authorization") String auth_token) {

		return advertisementService.updateAdvertiseByID(id, newAdvertise, auth_token);
	}

	@PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Create New Advertisement")
	public Advertise createNewAdvertise(@RequestBody Advertise advertise, @RequestHeader("Authorization") String auth_token) {
	    return advertisementService.createNewAdvertise(advertise, auth_token);
	}

}
