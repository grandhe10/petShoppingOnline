package com.demo.onlinepetshop.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.onlinepetshop.model.OrderHistory;
import com.demo.onlinepetshop.model.User;

/**
 * @author Suma
 * This interface extends CurdRepository 
 *
 */
@Repository
public interface OrderHistoryDao extends CrudRepository<OrderHistory, Long>{

	/**
	 * This method is used to get the Order History of a user
	 * @param user
	 * @return List of orders
	 */
	Optional<List<OrderHistory>> findByUser(User user);

}
