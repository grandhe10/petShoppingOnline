package com.demo.onlinepetshop.dto;

/**
 * @author Suma
 * Generates class with parameters message and statusCode
 *
 */
public class LoginResponseDto {
	
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
