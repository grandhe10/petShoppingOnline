package com.demo.onlinepetshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long petId;
	private String petAnimalName;
	private String breed;
	private int age;
	private String gender;
	private double price;
	
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
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
}
