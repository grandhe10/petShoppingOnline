package com.demo.onlinepetshop.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author Suma
 * Generates class with parameters userName,password
 *
 */
public class LoginDto {
	@NotEmpty(message = "UserName is mandatory field")
	private String userName;
	@NotEmpty(message = "password is mandatory field")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
