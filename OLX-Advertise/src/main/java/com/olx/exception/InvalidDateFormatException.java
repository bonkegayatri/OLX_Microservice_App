package com.olx.exception;

public class InvalidDateFormatException extends RuntimeException {

	private String message;

	public InvalidDateFormatException() {
		this.message = "";
	}

	public InvalidDateFormatException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidDateFormatException Date =" + message + "";
	}
	
}
