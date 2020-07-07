package com.demo.onlinepetshop.dto;

import java.time.LocalDateTime;

/**
 * @author Suma
 * Generates class with parameters petAnimalname,breed,
 * age,gender,price,orderTime
 *
 */
public class OrderHistoryDto {
	

	private String petAnimalName;
	private String breed;
	private int age ;
	private String gender;
	private double price ;
	private LocalDateTime orderTime;
	public String getPetAnimalName() {
		return petAnimalName;
	}
	public void setPetAnimalName(String petAnimalName) {
		this.petAnimalName = petAnimalName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	

}
