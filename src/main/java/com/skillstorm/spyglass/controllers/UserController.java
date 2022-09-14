package com.skillstorm.spyglass.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spyglass.models.User;
import com.skillstorm.spyglass.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name ="Users")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successful"),
		@ApiResponse(responseCode = "201", description = "Created"),
		@ApiResponse(responseCode = "401", description = "Unauthorized")
})
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user/{userId}")
	@Operation(summary = "Find user by id", description = "returns the user")
	public ResponseEntity<Optional<User>> findById(@PathVariable(value = "userId") int userId) {
		Optional<User> user = service.findById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user/email/{email}")
	@Operation(summary = "Find user by email", description = "returns the user")
	public ResponseEntity<User> findByEmail(@PathVariable(value = "email") String email) {
		User user = service.findByEmail(email);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/validate/{email}/{password}")
	@Operation(summary = "Used to validate user using their email and password", description = "returns the user if email and password match")
	public ResponseEntity<User> validateUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
		User user = service.validateUser(email, password);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	@Operation(summary = "Create a new user", description = "returns the created user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User u = service.createUser(user);
		return ResponseEntity.ok(u);
	}
	
	@PutMapping
	@Operation(summary = "Update an existing user", description = "returns the updated user")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		User u = service.updateUser(user);
		return ResponseEntity.ok(u);
	}
	
	@DeleteMapping("/{userId}")
	@Operation(summary = "Deletes an user", description = "returns true or false depending on success")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "userId") int userId){
		service.deleteUser(userId);
		return ResponseEntity.ok(true);
	}
}
