package com.olx.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "olxBlockToken")
public class TokenDocument {

	@Id
	private int id;
	private String token;
	
	@Override
	public String toString() {
		return "TokenDocument [id=" + id + ", token=" + token + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenDocument(int id, String token) {
		super();
		this.id = id;
		this.token = token;
	}

	public TokenDocument(String token) {
		super();
		this.token = token;
	}

	public TokenDocument() {
	
	}
	
	
	
}
