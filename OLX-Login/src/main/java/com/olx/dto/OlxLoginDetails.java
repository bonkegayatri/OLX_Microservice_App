package com.olx.dto;


public class OlxLoginDetails {
	
	private int id;
	private String username;
	private String password;
	private String roles;
	
	public OlxLoginDetails() {}
	
	public OlxLoginDetails(int id, String username, String password, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public OlxLoginDetails(String username, String password, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "LoginDetails [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ "]";
	}
	
	
}
