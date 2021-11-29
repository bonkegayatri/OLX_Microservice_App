package com.olx.exception;

public class InvalidFromDateException  extends RuntimeException {

	private String message;

	public InvalidFromDateException() {
		this.message = "";
	}

	public InvalidFromDateException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidFromDateException date =" + message + "";
	}
	
}
