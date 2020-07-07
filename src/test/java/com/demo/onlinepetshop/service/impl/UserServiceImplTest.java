package com.demo.onlinepetshop.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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
import org.springframework.http.HttpStatus;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.OrderHistoryDao;
import com.demo.onlinepetshop.dao.PetDao;
import com.demo.onlinepetshop.dao.UserDao;
import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.OrderHistoryDto;
import com.demo.onlinepetshop.exception.UserNotFoundException;
import com.demo.onlinepetshop.exception.UserUnauthorisedException;
import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.Pet;
import com.demo.onlinepetshop.model.User;
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	LoginResponseDto loginResponseDto;
	
	@Mock
	OrderHistoryDao orderHistoryDao;
	
	@Mock
	PetDao petDao;

	@BeforeEach
	public void setUp() {

	}
		
	@Test
	public void loginUserTest() {
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("TEST123");
		loginDto.setPassword("test123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("user logged in successfully");
		loginResponseDto.setStatusCode(HttpStatus.FOUND.value());

		User user = new User();
		user.setPassword("test123");
		user.setUserId(1L);
		user.setUserName("TEST123");	
	
		when(userDao.findByUserNameAndPassword(any(String.class),any(String.class))).thenReturn(Optional.of(user));
		userServiceImpl.loginUser(loginDto);
		verify(userDao).findByUserNameAndPassword("TEST123", "test123");

	}
	
	@Test
	public void loginUserTest1() throws UserUnauthorisedException{
		
		LoginDto loginDto = new LoginDto();
		loginDto.setUserName("TEST123");
		loginDto.setPassword("test123");

		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage(ApplicationConstants.USER_LOGGED_IN);
		loginResponseDto.setStatusCode(ApplicationConstants.USER_LOGGED_CODE);

		User user = new User();
		user.setPassword("test123");
		user.setUserId(1L);
		user.setUserName("TEST123");	
		
		
	    UserUnauthorisedException exception = assertThrows(UserUnauthorisedException.class, () -> {
	        userServiceImpl.loginUser(loginDto);
	    });
	 
	    String expectedMessage = ApplicationConstants.UNAUTHORIZED_USER;
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	}
	
	@Test
	public void getOrderHistoryTest()
	{
		Long userId = 1L;
		User user = new User();
    	user.setPassword("test123");
    	user.setUserId(1L);
    	user.setUserName("TEST123");
       
    	OrderHistory orderHistory = new OrderHistory();
    	
    	orderHistory.setOrderHistoryId(1L);
    	orderHistory.setOrderTime(LocalDateTime.now());
    	orderHistory.setPetId(1L);
    	orderHistory.setUser(user);
    	
    	List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();
    	
    	OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
    	orderHistoryDto.setAge(2);
    	orderHistoryDto.setBreed("breed1");
    	orderHistoryDto.setGender("male");
    	orderHistoryDto.setOrderTime(orderHistory.getOrderTime());
    	orderHistory.setUser(user);
    	
    	orderHistoryDtoList.add(orderHistoryDto);
    	
    	 UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
 	        userServiceImpl.getOrderHistory(userId);
 	    });
 	 
 	    String expectedMessage = ApplicationConstants.USER_NOT_FOUND;
 	    String actualMessage = exception.getMessage();
 	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void getOrderHistoryTest1()
	{
		Long userId = 1L;
		User user = new User();
    	user.setPassword("test123");
    	user.setUserId(1L);
    	user.setUserName("TEST123");
       
    	OrderHistory orderHistory = new OrderHistory();
    	
    	orderHistory.setOrderHistoryId(1L);
    	orderHistory.setOrderTime(LocalDateTime.now());
    	orderHistory.setPetId(1L);
    	orderHistory.setUser(user);
    	
    	List<OrderHistory> orderHistoryList = new ArrayList<>();
    	orderHistoryList.add(orderHistory);
    	List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();
    	
    	OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
    	orderHistoryDto.setAge(2);
    	orderHistoryDto.setBreed("breed1");
    	orderHistoryDto.setGender("male");
    	orderHistoryDto.setOrderTime(orderHistory.getOrderTime());
    	orderHistory.setUser(user);
    	
    	orderHistoryDtoList.add(orderHistoryDto);
    	
    	Pet pet = new Pet();
    	pet.setAge(2);
    	pet.setBreed("breed");
    	pet.setGender("female");
    	pet.setPetAnimalName("petAnilamlname");
    	pet.setPetId(1L);
    	pet.setPrice(200);
    	
    	
    	when(userDao.findByUserId(1L)).thenReturn(Optional.of(user));
    	when(orderHistoryDao.findByUser(user)).thenReturn(Optional.of(orderHistoryList));
    	when(petDao.findByPetId(1L)).thenReturn(Optional.of(pet));
    	userServiceImpl.getOrderHistory(1L);
    	verify(userDao).findByUserId(1L);
    	verify(petDao).findByPetId(1L);
	}
}
