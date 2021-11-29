package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.olx.dto.OlxLoginDetails;
import com.olx.entity.OlxLoginEntity;
import com.olx.repo.OlxLoginRepo;

@Service
public class OlxLoginServiceImpl implements OlxLoginService{

	@Autowired
	OlxLoginRepo olxLoginRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Bean
	public ModelMapper modelMapper() {
	 return new ModelMapper();
	}
	
	@Override
	public OlxLoginDetails createNewOlxLoginDetails(OlxLoginDetails olxLoginDetails) {
		OlxLoginEntity olxLoginEntity = getOlxLoginEntityFromDto(olxLoginDetails);
		olxLoginEntity = olxLoginRepo.save(olxLoginEntity);
		return getOlxLoginDtoFromEntity(olxLoginEntity);
	}
	
	private OlxLoginEntity getOlxLoginEntityFromDto(OlxLoginDetails olxLoginDetails) {
//		return new StockEntity(stock.getName(),stock.getMarket(),stock.getPrice());
		
//		TypeMap<OlxLoginDetails,OlxLoginEntity> typeMap = this.modelMapper.typeMap(OlxLoginDetails.class, OlxLoginEntity.class);
//		typeMap.addMappings(mapper->{
//			mapper.map(source-> source.getMarketName(), OlxLoginDetails::setMarket);
//		});
//	
		
		OlxLoginEntity olxLoginEntity = this.modelMapper.map(olxLoginDetails, OlxLoginEntity.class);
		return olxLoginEntity;
	}
	
	
	private OlxLoginDetails getOlxLoginDtoFromEntity(OlxLoginEntity olxLoginEntity) {
//		return new Stock(stockEntity.getId(),stockEntity.getName(),stockEntity.getMarket(),stockEntity.getPrice());
		
//		TypeMap<OlxLoginEntity, Stock> typeMap = this.modelMapper.typeMap(StockEntity.class, Stock.class);
//		typeMap.addMappings(mapper->{
//			mapper.map(source-> source.getMarket(), Stock::setMarketName);
//		});
	
	
		OlxLoginDetails olxLoginDetails = this.modelMapper.map(olxLoginEntity, OlxLoginDetails.class);
		return olxLoginDetails;
		
	}

	@Override
	public List<OlxLoginDetails> getAllOlxLoginDetails() {
	
		List<OlxLoginEntity> listStockEntity = olxLoginRepo.findAll();
		return getLoginDtoListFromEntity(listStockEntity);
	}
	
	
	private List<OlxLoginDetails> getLoginDtoListFromEntity(List<OlxLoginEntity> stockEntityList) {
		List<OlxLoginDetails> stockDtoList = new ArrayList<OlxLoginDetails>();
		for(OlxLoginEntity stockEntity: stockEntityList) {
			stockDtoList.add(getOlxLoginDtoFromEntity(stockEntity));
		}
		return stockDtoList;
		
	}
	

}
