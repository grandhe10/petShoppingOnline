package com.demo.onlinepetshop.service;

import java.util.List;

import com.demo.onlinepetshop.dto.PetAnimalResponse;

/**
 * @author Suma
 *
 */
public interface PetService {

	/**
	 * This method is used to get the list of petAnimal breeds available of particular type
	 * @param petAnimalName
	 * @return list of petAnimls
	 */
	List<PetAnimalResponse> getListByPetAnimalName(String petAnimalName);

	

}
