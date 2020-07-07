package com.demo.onlinepetshop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.onlinepetshop.controller.OrderHistoryController;
import com.demo.onlinepetshop.controller.PetController;
import com.demo.onlinepetshop.controller.UserController;

@SpringBootTest
class ApplicationTests {

	@Autowired
	PetController petController;
	@Autowired
	UserController userController;
	@Autowired
	OrderHistoryController orderHistoryController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(petController).isNotNull();
	}
	@Test
	public void contexLoads1() throws Exception {
		assertThat(userController).isNotNull();
	}
	@Test
	public void contexLoads2() throws Exception {
		assertThat(orderHistoryController).isNotNull();
	}

}
