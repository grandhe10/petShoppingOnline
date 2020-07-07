package com.demo.onlinepetshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;
import com.demo.onlinepetshop.service.OrderHistoryService;
/**
 * @author Suma
 * This controller is used to send request related to order
 * and get a response based on the request
 *
 */
@RestController
public class OrderHistoryController {
	
	Log logger = LogFactory.getLog(OrderHistoryController.class);
	
	@Autowired
	OrderHistoryService orderHistoryService;
	
	/**
	 * This method is used to place order 
	 * @param petDtoList
	 * @param userId
	 * @return ResponseEntity with header,OrderResponseDto with parameters message and statusCode
	 */
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderResponseDto> placeOrder(@Valid @RequestBody List<PetDto> petDtoList,@PathVariable("userId") Long userId)
	{
		logger.info(ApplicationConstants.LOGINFO_ORDERCONTROLLER_1);
		return new ResponseEntity<>(orderHistoryService.placeOrder(petDtoList,userId),HttpStatus.CREATED);
	}
	
	

}
