package com.skillstorm.spyglass.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.repositories.GoalRepository;

@Service
@Transactional
public class GoalService {

	@Autowired
	private GoalRepository repository;
	
	public List<Goal> findByUser(int userId) {
		return repository.findByUser(userId);
	}
	
	public Goal createGoal(Goal goal) {
		return repository.save(goal);
	}

	public Goal updateGoal(Goal goal) {
		return repository.save(goal);
	}
	
	public void deleteGoal(int goalId) {
		repository.deleteById(goalId);
	}
}









