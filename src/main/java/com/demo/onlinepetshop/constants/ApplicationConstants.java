package com.demo.onlinepetshop.constants;

import org.springframework.http.HttpStatus;

public class ApplicationConstants {

	private ApplicationConstants()
	{
		
	}
	public static final Integer INVALD_INPUT = 417;
	public static final String UNAUTHORIZED_USER = "User credentials incorrect!! Please verify";
	public static final Integer UNAUTHORIZED_USER_CODE =HttpStatus.UNAUTHORIZED.value();
	public static final String USER_NOT_FOUND = "Please verify userId";
	public static final Integer USER_NOT_FOUND_CODE = 600;
	public static final String PET_NOT_FOUND = "No pets found !!!Please verify your input";
	public static final Integer PET_NOT_FOUND_CODE = 601;
	public static final int USER_LOGGED_CODE = HttpStatus.FOUND.value();
	public static final String USER_LOGGED_IN = "user logged in successfully";
	public static final Object LOGINFO_USER_1 = "Authenticating user";
	public static final Object LOGINFO_USERCONTROLLER_1 = "UserService method Login User is  found";
	public static final Object LOGINFO_USER_2 = "User found ";
	public static final Object LOGINFO_USER_3 = "User not found";
	
	
	

}
