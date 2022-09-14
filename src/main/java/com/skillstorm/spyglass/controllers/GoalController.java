package com.skillstorm.spyglass.controllers;

import java.util.List;

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

import com.skillstorm.spyglass.models.Goal;
import com.skillstorm.spyglass.services.GoalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/goals")
@Tag(name = "Goals")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Successful"),
		@ApiResponse(responseCode = "201", description = "Created"),
		@ApiResponse(responseCode = "401", description = "Unauthorized")
})
@CrossOrigin(origins="http://localhost:4200")
public class GoalController {

	@Autowired
	private GoalService service;
	
	@GetMapping("/user/{userId}")
	@Operation(summary = "Find all goals for a user", description = "returns a list of goals")
	public ResponseEntity<List<Goal>> findByUser(@PathVariable(value = "userId") int userId) {
		List<Goal> goals = service.findByUser(userId);
		return ResponseEntity.ok(goals);
	}
	
	@PostMapping
	@Operation(summary = "Create a new goal", description = "returns the created goal")
	public ResponseEntity<Goal> createGoal(@Valid @RequestBody Goal goal){
		Goal g = service.createGoal(goal);
		return ResponseEntity.ok(g);
	}
	
	@PutMapping
	@Operation(summary = "Update an existing goal", description = "returns the updated goal")
	public ResponseEntity<Goal> updateGoal(@Valid @RequestBody Goal goal){
		Goal g = service.updateGoal(goal);
		return ResponseEntity.ok(g);
	}
	
	@DeleteMapping("/{goalId}")
	@Operation(summary = "Delete a goal", description = "Returns true or false depending on succes")
	public ResponseEntity<Boolean> deleteGoal(@PathVariable(value = "goalId") int goalId){
		service.deleteGoal(goalId);
		return ResponseEntity.ok(true);
	}
}















