package com.skillstorm.spyglass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.spyglass.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>{

	@Query("FROM Goal g JOIN g.user a where a.userId = :user")
	public List<Goal> findByUser(int user);
}
