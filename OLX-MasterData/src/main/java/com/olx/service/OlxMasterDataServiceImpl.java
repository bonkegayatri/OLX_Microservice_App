package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repo.CategoryRepo;
import com.olx.repo.OlxMasterDataStatusRepo;


@Service
public class OlxMasterDataServiceImpl implements OlxMasterDataService {

//	@Override
//	public List<Category> getAllCategories(){
//	List<Category> categories = new ArrayList<Category>();
//	categories.add(new Category(1,"Furniture"));
//	categories.add(new Category(2,"FuReal Estate"));
//	return categories;
//	}
//
//	@Override
//	public List<Status> getAllStatus(){
//	List<Status> categories = new ArrayList<Status>();
//	categories.add(new Status(1,"Furniture"));
//	categories.add(new Status(2,"FuReal Estate"));
//	return categories;
//	}
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	@Lazy
	OlxMasterDataStatusRepo olxMasterDataStatusRepo;
	
	
	@Autowired
	@Lazy
	ModelMapper modelMapper;

	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}

	@Override
	public List<Category> getAllCategories() {
		List<CategoryEntity> categoryEntityList = categoryRepo.findAll();
		return getCategoryDtoListFromEntity(categoryEntityList);
	}
	
	
	private List<Category> getCategoryDtoListFromEntity(List<CategoryEntity> stockEntityList) {
		List<Category> stockDtoList = new ArrayList<Category>();
		for(CategoryEntity stockEntity: stockEntityList) {
			stockDtoList.add(getCategoryDtoFromEntity(stockEntity));
		}
		return stockDtoList;
		
	}
	
	private Category getCategoryDtoFromEntity(CategoryEntity olxLoginEntity) {	
     	Category olxLoginDetails = this.modelMapper.map(olxLoginEntity, Category.class);
		return olxLoginDetails;
	}
	
	@Override
	public List<Status> getAllStatus() {
		List<StatusEntity> categoryEntityList = olxMasterDataStatusRepo.findAll();
		return getStatusDtoListFromEntity(categoryEntityList);
	}
	
	private List<Status> getStatusDtoListFromEntity(List<StatusEntity> stockEntityList) {
		List<Status> stockDtoList = new ArrayList<Status>();
		for(StatusEntity stockEntity: stockEntityList) {
			stockDtoList.add(getStatusDtoFromEntity(stockEntity));
		}
		return stockDtoList;
		
	}

	private Status getStatusDtoFromEntity(StatusEntity olxLoginEntity) {	
		Status olxLoginDetails = this.modelMapper.map(olxLoginEntity, Status.class);
		return olxLoginDetails;
	}
	
	
}
