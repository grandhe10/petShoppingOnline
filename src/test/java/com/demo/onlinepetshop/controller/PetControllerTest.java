package com.demo.onlinepetshop.controller;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.eq;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.onlinepetshop.dto.PetAnimalResponse;
import com.demo.onlinepetshop.service.PetService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {
	
	@Mock
    PetService petService;

	MockMvc mockMvc;
    ObjectMapper objectMapper;

    @InjectMocks
    PetController petController;
    
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();   
        
    }
 
    @Test
    public void getPetAnimalsList() throws Exception
    {
    	PetAnimalResponse petAnimalResponse = new PetAnimalResponse();
    	
    	petAnimalResponse.setAge(2);
    	petAnimalResponse.setBreed("breed1");
    	petAnimalResponse.setGender("femalde");
    	petAnimalResponse.setPetAnimalName("petAnimal");
    	petAnimalResponse.setPetId(1L);
    	petAnimalResponse.setPrice(2000);
   
    	List<PetAnimalResponse> petAnimalResponseList = new ArrayList<>();
    	
    	petAnimalResponseList.add(petAnimalResponse);
    	
    	when(petService.getListByPetAnimalName(eq("petAnimal"))).thenReturn(petAnimalResponseList);
		
		  mockMvc.perform(get("/pets").
				  contentType(MediaType.APPLICATION_JSON_VALUE)
				  .param("petAnimalName","petAnimal")
				  .accept(MediaType.APPLICATION_JSON_VALUE))
		  .andExpect(status().isOk()) 
		  .andExpect(jsonPath("$.[0]", Matchers.any(LinkedHashMap.class)));
		  verify(petService).getListByPetAnimalName((eq("petAnimal")));
    	
    	
    }
}
