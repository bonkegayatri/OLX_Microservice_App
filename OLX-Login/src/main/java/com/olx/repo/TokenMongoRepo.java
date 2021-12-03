package com.olx.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olx.entity.TokenDocument;


public interface TokenMongoRepo extends MongoRepository<TokenDocument, Integer>{

}
