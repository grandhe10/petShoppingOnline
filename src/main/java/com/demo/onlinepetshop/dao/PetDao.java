package com.demo.onlinepetshop.dao;

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

}
