package com.olx.service;

import java.util.List;

import com.olx.dto.UserToken;


public interface TokenService {

	public boolean saveToken(UserToken userToken);
	public List<UserToken> getAllToken();


}
