package com.olx.exception;

public class InvalidCategoryIdException extends RuntimeException {

	private String message;

	public InvalidCategoryIdException() {
		this.message = "";
	}

	public InvalidCategoryIdException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidCategoryIdException Id =" + message + "";
	}
	
}
