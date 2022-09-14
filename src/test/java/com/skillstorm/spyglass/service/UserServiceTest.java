package com.skillstorm.spyglass.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.skillstorm.spyglass.models.User;
import com.skillstorm.spyglass.services.UserService;

@SpringBootTest
@AutoConfigureMockMvc()
@ActiveProfiles("dev")
public class UserServiceTest {

	@Autowired
	private UserService service;
	
	@Test
	void findByIdTest() {
		assertNotNull(service);
		// User with id 1 exists, should return a user
		Optional<User> user = service.findById(1);
		assertNotNull(user);
	}
	
	@Test
	void findByNonExistingIdTest() {
		assertNotNull(service);
		// User with id 0 does not exist, should not return a user
		Optional<User> user = service.findById(0);
		assertTrue(user.isEmpty());
	}
	
	@Test
	void findByEmailTest() {
		assertNotNull(service);
		// User with this email exists, should return a user
		User user = service.findByEmail("dominic@gmail.com");
		assertNotNull(user);
	}
	
	@Test
	void findByNonExistingEmailTest() {
		assertNotNull(service);
		// User with id 0 does not exist, should not return a user
		User user = service.findByEmail("doesnotexist@gmail.com");
		assertNull(user);
	}
	
	@Test
	void validateUserTest() {
		assertNotNull(service);
		// User with these credentials exist, should return a user
		User user = service.validateUser("dominic@gmail.com", "password");
		assertNotNull(user);
	}
	
	@Test
	void validateIncorrectUserTest() {
		assertNotNull(service);
		// User with these credentials does not exist, should not return a user
		User user = service.validateUser("dominic@gmail.com", "wrongpassword");
		assertNull(user);
	}
}
