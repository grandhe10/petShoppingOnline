package com.demo.onlinepetshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinepetshop.model.User;
/**
 * @author Suma
 * This interface extends CurdRepository 
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Long>{

}
