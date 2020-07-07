package com.demo.onlinepetshop.service.impl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.UserDao;
import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.exception.UserUnauthorisedException;
import com.demo.onlinepetshop.model.User;
import com.demo.onlinepetshop.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	Log logger = LogFactory.getLog(UserServiceImpl.class);
	
	
	@Autowired
	UserDao userDao;
	
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

}
