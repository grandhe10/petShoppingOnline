package com.demo.onlinepetshop.service;

import java.util.List;

import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;

public interface OrderHistoryService {

	OrderResponseDto placeOrder(List<PetDto> petDtoList,Long userId);

}
