package com.demo.onlinepetshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.OrderHistoryDto;
import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.User;
import com.demo.onlinepetshop.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Mock
    UserService userService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    UserController userController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();   
        
    }
    
    @Test
    public void userLoginTest() throws Exception
    {
		LoginDto loginDto = new LoginDto();
		
		loginDto.setUserName("1234");
		loginDto.setPassword("test");
		
       LoginResponseDto loginResponseDto = new LoginResponseDto();
       
       loginResponseDto.setMessage(ApplicationConstants.USER_LOGGED_IN);
       loginResponseDto.setStatusCode(ApplicationConstants.USER_LOGGED_CODE);
       
        when(userService.loginUser(any(LoginDto.class))).thenReturn(loginResponseDto);
        mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

        verify(userService).loginUser(any(LoginDto.class));
    }

    @Test
    public void getOrderHistoryTest() throws Exception
    {
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
    	
        when(userService.getOrderHistory(eq(1L))).thenReturn(orderHistoryDtoList);
        mockMvc.perform(get("/users/{userId}/orders",1L)
        	      .contentType(MediaType.APPLICATION_JSON))
        	      .andExpect(status().isFound())
        	      .andExpect(content()
        	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        	      .andExpect(jsonPath("$.[0]", Matchers.any(LinkedHashMap.class)));

        verify(userService).getOrderHistory(eq(1L));
    }
    
    
    
}