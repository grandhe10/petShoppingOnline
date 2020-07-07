package com.demo.onlinepetshop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.onlinepetshop.constants.ApplicationConstants;
import com.demo.onlinepetshop.dao.PetDao;
import com.demo.onlinepetshop.dto.PetAnimalResponse;
import com.demo.onlinepetshop.exception.PetNotFoundException;
import com.demo.onlinepetshop.model.Pet;
import com.demo.onlinepetshop.service.PetService;

@Service
public class PetServiceImpl implements PetService{

	Log logger = LogFactory.getLog(PetServiceImpl.class);
	
	@Autowired
	PetDao petDao;
	@Override
	public List<PetAnimalResponse> getListByPetAnimalName(String petAnimalName) {
		
		logger.info(ApplicationConstants.LOGINFO_PET_1);
		Optional<List<Pet>> petList = petDao.findByPetAnimalNameContaining(petAnimalName);
		
		if(!petList.isPresent())	
		{
			logger.info(ApplicationConstants.LOGINFO_PET_4);	
			throw new PetNotFoundException(ApplicationConstants.PET_NOT_FOUND);
		}
		
		List<PetAnimalResponse> responseList = petList.get().stream().map(this::getPetAnimal).collect(Collectors.toList());
		
		logger.info(ApplicationConstants.LOGINFO_PET_3);
		
		return responseList;
	}

	private PetAnimalResponse getPetAnimal(Pet pet)
	{
		logger.info(ApplicationConstants.LOGINFO_PET_2);
		PetAnimalResponse petAnimalResponse = new PetAnimalResponse();
		
		petAnimalResponse.setAge(pet.getAge());
		petAnimalResponse.setBreed(pet.getBreed());
		petAnimalResponse.setGender(pet.getGender());
		petAnimalResponse.setPetId(pet.getPetId());
		petAnimalResponse.setPrice(pet.getPrice());
		petAnimalResponse.setPetAnimalName(pet.getPetAnimalName());
		
		return petAnimalResponse;
		
	}

	
}
