package com.demo.onlinepetshop.service.impl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.PetDao;
import com.demo.onlinepetshop.dao.UserDao;
import com.demo.onlinepetshop.dto.LoginResponseDto;
import com.demo.onlinepetshop.dto.PetAnimalResponse;
import com.demo.onlinepetshop.exception.PetNotFoundException;
import com.demo.onlinepetshop.exception.UserUnauthorisedException;
import com.demo.onlinepetshop.model.Pet;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PetServiceImplTest {
	
	@Mock
	PetDao petDao;

	@InjectMocks
	PetServiceImpl petServiceImpl;
	
	
	@Test
	public void getListByPetAnimalNameTest()
	{
	PetAnimalResponse petAnimalResponse = new PetAnimalResponse();
	
	petAnimalResponse.setAge(2);
	petAnimalResponse.setBreed("breed1");
	petAnimalResponse.setGender("femalde");
	petAnimalResponse.setPetAnimalName("petAnimal");
	petAnimalResponse.setPetId(1L);
	petAnimalResponse.setPrice(2000);

	List<PetAnimalResponse> petAnimalResponseList = new ArrayList<>();
	
	petAnimalResponseList.add(petAnimalResponse);
	
	Pet pet = new Pet();
	pet.setAge(2);
	pet.setBreed("breed");
	pet.setGender("female");
	pet.setPetAnimalName("petAnilamlname");
	pet.setPetId(1L);
	pet.setPrice(200);
	
	List<Pet> petAnimalList = new ArrayList<>();
	petAnimalList.add(pet);
	
	when(petDao.findByPetAnimalNameContaining(any(String.class))).thenReturn(Optional.of(petAnimalList));
	petServiceImpl.getListByPetAnimalName("petAnimalName");
	verify(petDao).findByPetAnimalNameContaining(any(String.class));
	}
	
	@Test
	public void getListByPetAnimalNameTest1()
	{
	PetAnimalResponse petAnimalResponse = new PetAnimalResponse();
	
	petAnimalResponse.setAge(2);
	petAnimalResponse.setBreed("breed1");
	petAnimalResponse.setGender("femalde");
	petAnimalResponse.setPetAnimalName("petAnimal");
	petAnimalResponse.setPetId(1L);
	petAnimalResponse.setPrice(2000);

	List<PetAnimalResponse> petAnimalResponseList = new ArrayList<>();
	
	petAnimalResponseList.add(petAnimalResponse);
	
	Pet pet = new Pet();
	pet.setAge(2);
	pet.setBreed("breed");
	pet.setGender("female");
	pet.setPetAnimalName("petAnilamlname");
	pet.setPetId(1L);
	pet.setPrice(200);
	
	List<Pet> petAnimalList = new ArrayList<>();
	petAnimalList.add(pet);
	
	 PetNotFoundException exception = assertThrows(PetNotFoundException.class, () -> {
	        petServiceImpl.getListByPetAnimalName("petAnimalName");
	    });
	 
	    String expectedMessage = ApplicationConstants.PET_NOT_FOUND;
	    String actualMessage = exception.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
