package com.demo.onlinepetshop.constants;

import org.springframework.http.HttpStatus;

public class ApplicationConstants {

	public static final Integer INVALD_INPUT = 417;
	public static final String UNAUTHORIZED_USER = "User credentials incorrect!! Please verify";
	public static final Integer UNAUTHORIZED_USER_CODE =HttpStatus.UNAUTHORIZED.value();
	public static final String USER_NOT_FOUND = "Please verify userId";
	public static final Integer USER_NOT_FOUND_CODE = 600;
	public static final String PET_NOT_FOUND = "No pets found !!!Please verify your input";
	public static final Integer PET_NOT_FOUND_CODE = 601;
	
	

}
