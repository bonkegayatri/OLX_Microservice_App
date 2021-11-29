package com.olx.exception;

public class InvalidOnDateException extends RuntimeException {

	private String message;

	public InvalidOnDateException() {
		this.message = "";
	}

	public InvalidOnDateException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidOnDateException date =" + message + "";
	}
	
}
