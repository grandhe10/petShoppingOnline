package com.demo.onlinepetshop.service;

import java.util.List;

import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;

/**
 * @author Suma
 *
 */
public interface OrderHistoryService {

	/**
	 * This method is used to place Order for requested petAnimals
	 * @param petDtoList
	 * @param userId
	 * @return OrderResponseDto with parameters message and statusCode
	 */
	OrderResponseDto placeOrder(List<PetDto> petDtoList,Long userId);

}
