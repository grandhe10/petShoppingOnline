package com.demo.onlinepetshop.exception;

/**
 * @author Suma
 * Generates class with parameters as message,statusCode 
 *
 */
public class ErrorResponse {
	
	private String message;
	private Integer statusCode;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
