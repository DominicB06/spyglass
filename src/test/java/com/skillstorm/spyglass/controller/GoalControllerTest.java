package com.skillstorm.spyglass.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.models.User;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
public class GoalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void findByUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/goals/user/1"))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void findByNonExistingUserTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/goals/user/0"))
                .andExpect(content().string("[]"));
	}
	
	@Test
	void findByUserInvalidInputTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
        		.get("/goals/user/aaa"))
                .andExpect(status().is4xxClientError());
	}
	
	@Test
	void createGoalTest() throws Exception{
		
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = mapper.writeValueAsString(getGoal());
		
		
		mockMvc.perform(MockMvcRequestBuilders
        		.post("/goals")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(json))
                .andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void updateGoalTest() throws Exception{
		ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		Goal goal = getGoal();
		goal.setGoalId(1);
		
		String json = mapper.writeValueAsString(goal);
		
		mockMvc.perform(MockMvcRequestBuilders
        		.put("/goals")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(json))
                .andExpect(status().is2xxSuccessful());
	}
	
//	@Test
//	void deleteGoalTest() throws Exception{
//		
//		mockMvc.perform(MockMvcRequestBuilders
//        		.delete("/goals/{goalid}", 1))
//                .andExpect(status().is2xxSuccessful());
//	}
//	
//	@Test
//	void deleteNonExistingGoalTest() throws Exception{
//		
//		mockMvc.perform(MockMvcRequestBuilders
//        		.delete("/goals/{goalid}", 0))
//                .andExpect(status().is5xxServerError());
//	}
	
	private Goal getGoal() {
		
		Goal goal = new Goal();
		User user = new User();
		user.setUserId(12);
		
		goal.setUser(user);
		goal.setName("test");
		goal.setDescription("test");
		goal.setPicture("test.png");
		goal.setTargetAmount(100);
		goal.setCurrentAmount(0);
		
		return goal;
	}
}


















