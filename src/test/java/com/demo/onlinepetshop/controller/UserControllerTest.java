package com.demo.onlinepetshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;

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

    
}