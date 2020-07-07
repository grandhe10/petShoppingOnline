package com.demo.onlinepetshop.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.OrderHistoryDao;
import com.demo.onlinepetshop.dao.PetDao;
import com.demo.onlinepetshop.dao.UserDao;
import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;
import com.demo.onlinepetshop.exception.UserNotFoundException;
import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.Pet;
import com.demo.onlinepetshop.model.User;

@ExtendWith(MockitoExtension.class)
public class OrderHistoryServiceImplTest {


	@Mock
	UserDao userDao;
	
	@Mock
	PetDao petDao;
	
	@Mock
	OrderHistoryDao orderHistoryDao;

	@InjectMocks
	OrderHistoryServiceImpl orderHistoryServiceImpl;
	
	OrderResponseDto orderResponseDto;

	@BeforeEach
	public void setUp() {

	}
	
	@Test
	public void placeOrderTest()
	{
		
		PetDto petDto = new PetDto();
    	petDto.setPetId(1L);
    	List<PetDto> petDtoList =  new ArrayList<>();
    	petDtoList.add(petDto);
    	
    	User user = new User();
    	user.setPassword("test123");
    	user.setUserId(1L);
    	user.setUserName("TEST123");
    	
    	Pet pet = new Pet();
    	pet.setAge(2);
    	pet.setBreed("breed");
    	pet.setGender("female");
    	pet.setPetAnimalName("petAnilamlname");
    	pet.setPetId(1L);
    	pet.setPrice(200);
    	
    	OrderHistory orderHistory = new OrderHistory();
    	orderHistory.setOrderHistoryId(1L);
    	orderHistory.setOrderTime(LocalDateTime.now());
    	orderHistory.setPetId(1L);
    	orderHistory.setUser(user);
    	
		OrderResponseDto orderResponseDto = new OrderResponseDto();
    	orderResponseDto.setMessage(ApplicationConstants.ORDER_SUCCESS);
    	orderResponseDto.setStatusCode(ApplicationConstants.ORDER_SUCCESS_CODE);
    	
    	when(userDao.findByUserId(user.getUserId())).thenReturn(Optional.of(user));
    	when(petDao.findByPetId(1L)).thenReturn(Optional.of(pet));
    	orderHistoryServiceImpl.placeOrder(petDtoList, 1L);
    	verify(userDao,times(2)).findByUserId(1L);
    	verify(petDao).findByPetId(1L);
    	verify(orderHistoryDao).save(any(OrderHistory.class));
    
	}
	
	@Test
	public void placeOrderTest1() throws UserNotFoundException
	{
		PetDto petDto = new PetDto();
    	petDto.setPetId(1L);
    	List<PetDto> petDtoList =  new ArrayList<>();
    	petDtoList.add(petDto);
    	
    	User user = new User();
    	user.setPassword("test123");
    	user.setUserId(1L);
    	user.setUserName("TEST123");
    	
    	Pet pet = new Pet();
    	pet.setAge(2);
    	pet.setBreed("breed");
    	pet.setGender("female");
    	pet.setPetAnimalName("petAnilamlname");
    	pet.setPetId(1L);
    	pet.setPrice(200);
    	
    	OrderHistory orderHistory = new OrderHistory();
    	orderHistory.setOrderHistoryId(1L);
    	orderHistory.setOrderTime(LocalDateTime.now());
    	orderHistory.setPetId(1L);
    	orderHistory.setUser(user);

    	
    	UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
 	        orderHistoryServiceImpl.placeOrder(petDtoList, 1L);
 	    });
    		
    	String expectedMessage = ApplicationConstants.USER_NOT_FOUND;
 	    String actualMessage = exception.getMessage();
 	    assertTrue(actualMessage.contains(expectedMessage));
    	
	}
	

	
}
