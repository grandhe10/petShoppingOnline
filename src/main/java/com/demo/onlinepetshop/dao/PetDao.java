package com.demo.onlinepetshop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinepetshop.model.Pet;
/**
 * @author Suma
 * This interface extends CurdRepository 
 *
 */
@Repository
public interface PetDao extends CrudRepository<Pet, Long>{

	/**
	 * This method is used to get Pet by petId
	 * @param petId
	 * @return Pet
	 */
	Optional<Pet> findByPetId(Long petId);

	/**
	 * This method is used to get PetAnimals list by petName
	 * @param petAnimalName
	 * @return List of Pets
	 */
	Optional<List<Pet>> findByPetAnimalNameContaining(String petAnimalName);
	
	
	

}
