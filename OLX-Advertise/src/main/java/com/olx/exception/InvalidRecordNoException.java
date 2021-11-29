package com.olx.exception;

public class InvalidRecordNoException extends RuntimeException {

	private String message;

	public InvalidRecordNoException() {
		this.message = "";
	}

	public InvalidRecordNoException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidRecordNoException :" + message + "";
	}
	
}
