package com.skillstorm.spyglass.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Optional<User>> findById(@PathVariable(value = "userId") int userId) {
		Optional<User> user = service.findById(userId);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User u = service.createUser(user);
		return ResponseEntity.ok(u);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		User u = service.updateUser(user);
		return ResponseEntity.ok(u);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "userId") int userId){
		service.deleteUser(userId);
		return ResponseEntity.ok(true);
	}
}
