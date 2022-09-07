package com.skillstorm.spyglass.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.repositories.GoalRepository;

@SpringBootTest
@AutoConfigureMockMvc()
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
public class GoalRepositoryTest {

	@Autowired
	private GoalRepository rep;
	
	@Test
	void findByUserTest() {
		assertNotNull(rep);
		// this user exists and has goals, a list of goals should be returned
		List<Goal> goals = rep.findByUser(1);
		assertFalse(goals.isEmpty());
	}
	
	@Test
	void findByNonExistingUserTest() {
		assertNotNull(rep);
		// a user with id 0 does not exist so goals should be empty
		List<Goal> goals = rep.findByUser(0);
		assertTrue(goals.isEmpty());
	}
}
