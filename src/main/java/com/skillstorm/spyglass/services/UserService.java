package com.skillstorm.spyglass.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spyglass.models.User;
import com.skillstorm.spyglass.repositories.UserReposoitory;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserReposoitory repository;
	
	public Optional<User> findById(int userId) {
		return repository.findById(userId);
	}
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public User validateUser(String email, String password) {
		User user = repository.findByEmailAndPassword(email, password);
		return user;
	}
	
	public User createUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public void deleteUser(int userId) {
		repository.deleteById(userId);
	}
}
