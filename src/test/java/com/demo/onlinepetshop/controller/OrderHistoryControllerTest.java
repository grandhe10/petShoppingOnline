package com.demo.onlinepetshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.demo.onlinepetshop.dto.OrderResponseDto;
import com.demo.onlinepetshop.dto.PetDto;
import com.demo.onlinepetshop.model.User;
import com.demo.onlinepetshop.service.OrderHistoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class OrderHistoryControllerTest {

	@Mock
    OrderHistoryService orderHistoryService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    OrderHistoryController orderHistoryController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(orderHistoryController).build();   
        
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void placeOrderTest() throws JsonProcessingException, Exception
    {
    	PetDto petDto = new PetDto();
    	petDto.setPetId(1L);
    	List<PetDto> petDtoList =  new ArrayList<>();
    	petDtoList.add(petDto);
    	User user = new User();
    	user.setPassword("test123");
    	user.setUserId(1L);
    	user.setUserName("TEST123");
    	
    	OrderResponseDto orderResponseDto = new OrderResponseDto();
    	orderResponseDto.setMessage(ApplicationConstants.ORDER_SUCCESS);
    	orderResponseDto.setStatusCode(ApplicationConstants.ORDER_SUCCESS_CODE);
    	
    	when(orderHistoryService.placeOrder(any(List.class),eq(1L))).thenReturn(orderResponseDto);
         mockMvc.perform(post("/users/{userId}/orders",1L).contentType(MediaType.APPLICATION_JSON_VALUE)
                 .content(objectMapper.writeValueAsString(petDtoList)))
                 .andExpect(status().isCreated())
                 .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));

         verify(orderHistoryService).placeOrder(any(List.class), eq(1L));

    	
    }
}
