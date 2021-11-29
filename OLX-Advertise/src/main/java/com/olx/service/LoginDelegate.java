package com.olx.service;


public interface LoginDelegate {

	public boolean validateToken(String auth_token);
}
