package com.olx.dto;

public class UserToken {
	
	private int id;
	private String token;
	
	public UserToken(int id, String token) {
		super();
		this.id = id;
		this.token = token;
	}
	public UserToken(String token) {
		super();
		this.token = token;
	}
	public UserToken() {
		
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
	@Override
	public String toString() {
		return "UserToken [id=" + id + ", token=" + token + "]";
	}
	
	

}
