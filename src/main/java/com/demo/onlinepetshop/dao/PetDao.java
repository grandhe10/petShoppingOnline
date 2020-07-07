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

	Optional<Pet> findByPetId(Long petId);

	Optional<List<Pet>> findByPetAnimalNameContaining(String petAnimalName);

}
