package com.demo.onlinepetshop.service.impl;

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
import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.OrderHistoryDto;
import com.demo.onlinepetshop.exception.NoOrdersFoundException;
import com.demo.onlinepetshop.exception.UserNotFoundException;
import com.demo.onlinepetshop.exception.UserUnauthorisedException;
import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.Pet;
import com.demo.onlinepetshop.model.User;
import com.demo.onlinepetshop.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderHistoryDao orderHistoryDao;
	
	@Autowired
	PetDao petDao;
	
	
	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		
		logger.info(ApplicationConstants.LOGINFO_USER_1);
		
		Optional<User> userOptional = userDao.findByUserNameAndPassword(loginDto.getUserName(),loginDto.getPassword());
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_USER_3);
			
			throw new UserUnauthorisedException(ApplicationConstants.UNAUTHORIZED_USER);
		}
		
		logger.info(ApplicationConstants.LOGINFO_USER_2);
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		
		loginResponseDto.setMessage(ApplicationConstants.USER_LOGGED_IN);
		loginResponseDto.setStatusCode(ApplicationConstants.USER_LOGGED_CODE);
		return loginResponseDto;
	}

	@Override
	public List<OrderHistoryDto> getOrderHistory(Long userId) {
		
		logger.info(ApplicationConstants.LOGINFO_USER_1);
		
		Optional<User> userOptional = userDao.findByUserId(userId);
		
		if(!userOptional.isPresent())
		{
			logger.info(ApplicationConstants.LOGINFO_USER_3);
			
			throw new UserNotFoundException(ApplicationConstants.USER_NOT_FOUND);
		}
		
		Optional<List<OrderHistory>> orderListOptional = orderHistoryDao.findByUser(userOptional.get());
		
		if(!orderListOptional.isPresent())
		{
			throw new NoOrdersFoundException(ApplicationConstants.NO_ORDERS_FOUND);
		}
		
		logger.info(ApplicationConstants.LOGINFO_USER_5);	
		
		List<OrderHistoryDto> orderHistoryList =  orderListOptional.get().stream().map(orderHistory->getOrderResponse(orderHistory)).collect(Collectors.toList());
		
		return orderHistoryList;
	}
	
	private OrderHistoryDto getOrderResponse(OrderHistory orderHistory)
	{
		OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
		Optional<Pet> petOptional = petDao.findByPetId(orderHistory.getPetId());
		if(!petOptional.isPresent())
			{
			logger.info(ApplicationConstants.LOGINFO_USER_4);	
				return null;
			}
		
		orderHistoryDto.setAge(petOptional.get().getAge());
		orderHistoryDto.setBreed(petOptional.get().getBreed());
		orderHistoryDto.setGender(petOptional.get().getGender());
		orderHistoryDto.setOrderTime(orderHistory.getOrderTime());
		orderHistoryDto.setPetAnimalName(petOptional.get().getPetAnimalName());
		orderHistoryDto.setPrice(petOptional.get().getPrice());
		
		return orderHistoryDto;
	}

}
