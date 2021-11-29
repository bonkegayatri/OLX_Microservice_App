package com.olx.service;

import java.util.List;

import com.olx.dto.Category;
import com.olx.dto.Status;


public interface OlxMasterDataService {
	
	public List<Category> getAllCategories();
	public List<Status> getAllStatus();

}
