package com.skillstorm.spyglass.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.skillstorm.spyglass.models.User;
import com.skillstorm.spyglass.repositories.UserReposoitory;

@SpringBootTest
@AutoConfigureMockMvc()
@ActiveProfiles("dev")
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserReposoitory rep;

	@Test
	void findByUserTest() {
		assertNotNull(rep);
		// a user with this email exists, so it should not be null
		User user = rep.findByEmail("dominic@gmail.com");
		assertNotNull(user);
	}
	
	@Test
	void findByNonExistingUserTest() {
		assertNotNull(rep);
		// a user with this email does not exist, should return null
		User user = rep.findByEmail("emaildoesnotexist@gmail.com");
		assertNull(user);
	}
	
	@Test
	void findByEmailAndPasswordTest() {
		assertNotNull(rep);
		// a user with this email and password exists, should not be null
		User user = rep.findByEmailAndPassword("dominic@gmail.com", "password");
		assertNotNull(user);
	}
	
	@Test
	void findByMismatchEmailAndPasswordTest() {
		assertNotNull(rep);
		// this is the wrong email for the given password, should return null
		User user = rep.findByEmailAndPassword("dominic@gmail.com", "wrongpassword");
		assertNull(user);
	}
}
