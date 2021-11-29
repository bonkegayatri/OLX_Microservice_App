package com.olx.service;

import java.util.List;

import com.olx.dto.OlxLoginDetails;


public interface OlxLoginService {

	public OlxLoginDetails createNewOlxLoginDetails(OlxLoginDetails olxLoginDetails);
	public List<OlxLoginDetails> getAllOlxLoginDetails();

}
