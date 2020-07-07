package com.demo.onlinepetshop.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.OrderHistoryDao;
import com.demo.onlinepetshop.dao.PetDao;
import com.demo.onlinepetshop.dao.UserDao;
import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;
import com.demo.onlinepetshop.exception.PetNotFoundException;
import com.demo.onlinepetshop.exception.UserNotFoundException;
import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.Pet;
import com.demo.onlinepetshop.model.User;
import com.demo.onlinepetshop.service.OrderHistoryService;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{

	Log logger = LogFactory.getLog(OrderHistoryServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PetDao petDao;
	
	@Autowired
	OrderHistoryDao orderHistoryDao;
	
	@Override
	public OrderResponseDto placeOrder(List<PetDto> petDtoList,Long userId) {
		
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_1);
		
		Optional<User> userOptional = userDao.findByUserId(userId); 
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_2);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_3);
		
		List<Long> petIdList = petDtoList.stream()
				.map(pet->validatePetId(pet)).collect(Collectors.toList());
		
		if(petIdList.contains(null))
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_4);
			
			throw new PetNotFoundException(ApplicationConstants.PET_NOT_FOUND);
		}
				
		List<Long> orderList = petIdList.stream().map(petId->saveOrder(petId,userId)).collect(Collectors.toList());
		
		if(orderList.contains(null))
		{
			logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_2);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		orderResponseDto.setMessage(ApplicationConstants.ORDER_SUCCESS);
		orderResponseDto.setStatusCode(ApplicationConstants.ORDER_SUCCESS_CODE);
		return orderResponseDto;
	}

	private Long validatePetId(PetDto petDto)
	{
		Optional<Pet> petOptional = petDao.findByPetId(petDto.getPetId());
		if(!petOptional.isPresent())
		return null;
		else
			return petOptional.get().getPetId();
		
	}
	private Long saveOrder(Long petId,Long userId)
	{
		Optional<User> userOptional = userDao.findByUserId(userId);
		if(!userOptional.isPresent())
			return null;
		OrderHistory  orderHistory = new OrderHistory();
		orderHistory.setOrderTime(LocalDateTime.now());
		orderHistory.setPetId(petId);
		orderHistory.setUser(userOptional.get());
		logger.info(ApplicationConstants.LOGINFO_ORDERHISTORY_5);
		orderHistoryDao.save(orderHistory);
		return userOptional.get().getUserId();
		
	}
}
