package com.skillstorm.spyglass.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import com.skillstorm.spyglass.models.User;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void findByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/users/user/{id}", 1))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void findByEmailTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/users/user/email/{email}", "dominic@gmail.com"))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void validateUserTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/users/validate/{email}/{password}", "dominic@gmail.com", "password"))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void createUserTest() throws Exception {
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		User user = getUser();
		user.setEmail("newemail");
		
		String json = mapper.writeValueAsString(user);
		
		mockMvc.perform(MockMvcRequestBuilders
        		.post("/users")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(json))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void updateUserTest() throws Exception {
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
				
		User user = getUser();
		user.setUserId(12);
		
		String json = mapper.writeValueAsString(user);
	
		mockMvc.perform(MockMvcRequestBuilders
        		.put("/users")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(json))
                .andExpect(status().is2xxSuccessful());
	}
	
	private User getUser() {
		User user = new User();
		
		user.setFname("test");
		user.setLname("test");
		user.setEmail("test");
		user.setPassword("test");
		
		return user;
	}
	
}









