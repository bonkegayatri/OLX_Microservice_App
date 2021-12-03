package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.UserToken;
import com.olx.entity.TokenDocument;
import com.olx.repo.TokenMongoRepo;

@Service(value = "MONGO_SERVICE")
public class TokenServiceMongoImpl implements TokenService{

	@Autowired
	TokenMongoRepo tokenMongoRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public boolean saveToken(UserToken userToken) {
		TokenDocument tokenDocument = getDocumentFromDto(userToken);
		tokenDocument = tokenMongoRepo.save(tokenDocument);
		return true;
	}

	@Override
	public List<UserToken> getAllToken() {
		List<TokenDocument> listDocument = tokenMongoRepo.findAll();
		return getDtoListFromDocument(listDocument);
	}
	
	private List<UserToken> getDtoListFromDocument(List<TokenDocument> tokenDocumentList) {
		List<UserToken> stockDtoList = new ArrayList<UserToken>();
		for(TokenDocument document: tokenDocumentList) {
			stockDtoList.add(getDtoFromDocument(document));
		}
		return stockDtoList;
	}

	private TokenDocument getDocumentFromDto(UserToken userToken) {		
		TokenDocument document = this.modelMapper.map(userToken, TokenDocument.class);
		return document;
	}

	private UserToken getDtoFromDocument(TokenDocument document) {		
		UserToken stock = this.modelMapper.map(document, UserToken.class);
		return stock;	
	}
	
}
