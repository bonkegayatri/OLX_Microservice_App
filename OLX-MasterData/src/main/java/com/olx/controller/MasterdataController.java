package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.OlxMasterDataService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("olx/masterdata")
public class MasterdataController {
	
	@Autowired
	OlxMasterDataService olxMasterDataService;

	@GetMapping(value="/advertise/category", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Get All Category")
	public List<Category> getAllCategories(){
	return olxMasterDataService.getAllCategories();
	}

	
	@GetMapping(value="/advertise/status", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Get All Status")
	public List<Status> getAllStatus(){
     return olxMasterDataService.getAllStatus();
	}

}