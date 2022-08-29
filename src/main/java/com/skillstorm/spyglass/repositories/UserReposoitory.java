package com.skillstorm.spyglass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.spyglass.models.User;

@Repository
public interface UserReposoitory extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	
//	@Query("UPDATE User u SET u.fname = :fname, u.lname = :lname WHERE u.userId = :userId")
//	@Modifying
//	public void updateName(String fname, String lname, int userId);
}
