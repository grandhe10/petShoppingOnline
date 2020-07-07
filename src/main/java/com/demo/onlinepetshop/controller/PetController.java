package com.demo.onlinepetshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.onlinepetshop.dto.PetAnimalResponse;
import com.demo.onlinepetshop.service.PetService;
/**
 * @author Suma
 * This controller is used to send request related to pet
 * and get a response based on the request
 *
 */
@RestController
public class PetController {
	
	@Autowired
	PetService petService;
	
	@GetMapping("/pets")
	public ResponseEntity<List<PetAnimalResponse>> getListByPetAnimalName(@RequestParam("petAnimalName") String petAnimalName)
	{
		return new ResponseEntity<>(petService.getListByPetAnimalName(petAnimalName),HttpStatus.OK);
	}

}
