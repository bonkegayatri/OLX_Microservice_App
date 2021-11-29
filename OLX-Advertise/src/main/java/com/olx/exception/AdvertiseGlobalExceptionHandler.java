package com.olx.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdvertiseGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {InvalidAuthTokenException.class})
	public ResponseEntity<Object> handleInvalidAuthTokenExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	@ExceptionHandler(value= {InvalidCategoryIdException.class})
	public ResponseEntity<Object> handleInvalidCategoryIdExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	@ExceptionHandler(value= {InvalidDateConditionException.class})
	public ResponseEntity<Object> handleInvalidDateConditionExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	
	@ExceptionHandler(value= {InvalidFromDateException.class})
	public ResponseEntity<Object> handleInvalidFromDateExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	
	@ExceptionHandler(value= {InvalidOnDateException.class})
	public ResponseEntity<Object> handleInvalidOnDateExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	@ExceptionHandler(value= {InvalidRecordNoException.class})
	public ResponseEntity<Object> handleInvalidRecordNoExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	@ExceptionHandler(value= {InvalidDateFormatException.class})
	public ResponseEntity<Object> handleInvalidDateFormatExceptionError(RuntimeException exception, WebRequest request){
		
	return handleExceptionInternal(exception,exception.toString(), new HttpHeaders(),
			HttpStatus.BAD_REQUEST, request	);
	}
	
	
}
