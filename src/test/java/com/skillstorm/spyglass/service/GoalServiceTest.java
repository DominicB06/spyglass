package com.skillstorm.spyglass.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.models.User;
import com.skillstorm.spyglass.services.GoalService;

@SpringBootTest
@AutoConfigureMockMvc()
@ActiveProfiles("dev")
public class GoalServiceTest {

	@Autowired
	private GoalService service;
	
	@Test
	void findByUserTest() {
		assertNotNull(service);
		// This user exists and has goals so goals should not be empty
		List<Goal> goals = service.findByUser(1);
		assertFalse(goals.isEmpty());
	}
	
	@Test
	void findByNonExistingUserTest() {
		assertNotNull(service);
		// This user does not exists so goals should be empty
		List<Goal> goals = service.findByUser(0);
		assertTrue(goals.isEmpty());
	}
	
	@Test
	void createGoalTest() {
		assertNotNull(service);
		// This should successfully create and return a goal
		Goal goal = service.createGoal(getGoal());
		assertNotNull(goal);
	}
	
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
