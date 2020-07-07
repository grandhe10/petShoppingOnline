package com.demo.onlinepetshop.dto;

import java.util.List;

/**
 * @author Suma
 * Generates class with parameter as list of petDtos
 *
 */
public class OrderRequestDto {

	private List<Long> petDtoList;

	public List<Long> getPetDtoList() {
		return petDtoList;
	}

	public void setPetDtoList(List<Long> petDtoList) {
		this.petDtoList = petDtoList;
	}

	
}
