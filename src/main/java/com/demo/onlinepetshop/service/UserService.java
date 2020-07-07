package com.demo.onlinepetshop.service;

import com.demo.onlinepetshop.dto.LoginDto;
import com.demo.onlinepetshop.dto.LoginResponseDto;

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

}
