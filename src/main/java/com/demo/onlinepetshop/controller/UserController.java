package com.demo.onlinepetshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.OrderHistoryDto;
import com.demo.onlinepetshop.service.UserService;

/**
 * @author Suma
 * This controller is used to send request related to user
 * and get a response based on the request
 *
 */
@RestController
public class UserController {
	
	Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserService userService;
	/**
	 * This method is used for User Authentication
	 * @param loginDto
	 * @return ResponseEntity with headers and LoginResponseDto with message and statusCode
	 */
	@PostMapping("/users")
	public ResponseEntity<LoginResponseDto> loginUser(@Valid @RequestBody LoginDto loginDto)
	{
		logger.info(ApplicationConstants.LOGINFO_USERCONTROLLER_1);
		return new ResponseEntity<>(userService.loginUser(loginDto),HttpStatus.OK);
	}

	/**
	 * This method is used to get the orderHistory by userId
	 * @param userId
	 * @return ResponseEntity with headers and List of orders in OrderHistory 
	 */
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<List<OrderHistoryDto>> getOrderHistory(@PathVariable("userId") Long userId)
	{
		logger.info(ApplicationConstants.LOGINFO_USERCONTROLLER_2);
		return new ResponseEntity<>(userService.getOrderHistory(userId),HttpStatus.FOUND);
	}
	
}
