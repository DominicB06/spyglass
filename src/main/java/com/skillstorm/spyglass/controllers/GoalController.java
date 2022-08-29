package com.skillstorm.spyglass.controllers;

import java.util.List;

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

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.services.GoalService;

@RestController
@RequestMapping("/goals")
public class GoalController {

	@Autowired
	private GoalService service;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Goal>> findByUser(@PathVariable(value = "userId") int userId) {
		List<Goal> goals = service.findByUser(userId);
		return ResponseEntity.ok(goals);
	}
	
	@PostMapping
	public ResponseEntity<Goal> createGoal(@Valid @RequestBody Goal goal){
		Goal g = service.createGoal(goal);
		return ResponseEntity.ok(g);
	}
	
	@PutMapping
	public ResponseEntity<Goal> updateGoal(@Valid @RequestBody Goal goal){
		Goal g = service.updateGoal(goal);
		return ResponseEntity.ok(g);
	}
	
	@DeleteMapping("/{goalId}")
	public ResponseEntity<Boolean> deleteGoal(@PathVariable(value = "goalId") int goalId){
		service.deleteGoal(goalId);
		return ResponseEntity.ok(true);
	}
}















