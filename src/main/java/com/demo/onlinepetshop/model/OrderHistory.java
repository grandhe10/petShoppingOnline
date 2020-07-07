package com.demo.onlinepetshop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class OrderHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long orderHistoryId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	private Long petId;
	private LocalDateTime orderTime;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public Long getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(Long orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	
	
}
