package com.demo.onlinepetshop.exception;

public class UserUnauthorisedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserUnauthorisedException(String exception) {
		super(exception);
	}
}