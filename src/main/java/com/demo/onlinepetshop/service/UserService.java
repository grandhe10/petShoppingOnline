package com.demo.onlinepetshop.service;

import java.util.List;

import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.OrderHistoryDto;
import com.demo.onlinepetshop.dto.OrderResponseDto;

/**
 * @author 91970
 *
 */
public interface UserService {

	/**
	 * This method is used for userLogin
	 * @param loginDto
	 * @return LoginResponseDto with parameters as message and statusCode
	 */
	public LoginResponseDto loginUser(LoginDto loginDto);

	/**
	 * This method is used to get the order History of a particular User
	 * @param userId
	 * @return List<OrderResponseDto>
	 */
	public List<OrderHistoryDto> getOrderHistory(Long userId);
	

}
