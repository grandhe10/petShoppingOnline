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
	public static final Object LOGINFO_ORDERCONTROLLER_1 = "orderHistory Servce method placeOrder is found";
	public static final Object LOGINFO_ORDERHISTORY_1 = "Verifying user";
	public static final Object LOGINFO_ORDERHISTORY_2 = "User not found";
	public static final String ORDER_SUCCESS = "Order placed successfully";
	public static final Integer ORDER_SUCCESS_CODE = HttpStatus.ACCEPTED.value();
	public static final Object LOGINFO_ORDERHISTORY_3 = "collecting petIds entered";
	public static final Object LOGINFO_ORDERHISTORY_4 = "petIds are not found";
	public static final Object LOGINFO_ORDERHISTORY_5 = "Order saved successfully";
	public static final Object LOGINFO_PET_1 = "fetching petAnimal list by animalName";
	public static final Object LOGINFO_PET_2 = "Enetered the getPetAnimal method";
	public static final Object LOGINFO_PET_3 = "Returning the list of pet animal breeds of particular animal";
	public static final Object LOGINFO_PET_4 = "No pet animal found with the request";
	
	
	

}
