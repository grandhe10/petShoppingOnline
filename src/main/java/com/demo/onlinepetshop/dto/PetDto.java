package com.demo.onlinepetshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class PetDto {
	@NotEmpty(message = "PetId cannot be empty")
	@Min(1)
	Long petId;

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

}
