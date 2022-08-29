package com.skillstorm.spyglass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.spyglass.models.User;

@Repository
public interface UserReposoitory extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
