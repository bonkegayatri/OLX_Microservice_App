package com.olx.exception;

public class InvalidDateConditionException extends RuntimeException {

	private String message;

	public InvalidDateConditionException() {
		this.message = "";
	}

	public InvalidDateConditionException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidDateConditionException date =" + message + "";
	}
	
}
