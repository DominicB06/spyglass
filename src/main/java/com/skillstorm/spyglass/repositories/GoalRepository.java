package com.skillstorm.spyglass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.spyglass.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>{

	@Query(value = "Select g from Goal g Where g.user = ?1")
	public List<Goal> findByUser(int userId);
}
