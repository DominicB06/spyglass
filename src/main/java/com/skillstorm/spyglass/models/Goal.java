package com.skillstorm.spyglass.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "goals")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goal_id")
	private int goalId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String desription;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "target_date")
	@Future
	private LocalDate targetDate;
	
	@Column(name = "target_amount")
	private double targetAmount;
	
	@Column(name = "current_amount")
	private double currentAmount;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	
	public Goal() {
		super();
	}
	
	public int getGoalId() {
		return goalId;
	}
	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public double getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "goal [goalId=" + goalId + ", name=" + name + ", desription=" + desription + ", picture=" + picture
				+ ", targetDate=" + targetDate + ", targetAmount=" + targetAmount + ", currentAmount=" + currentAmount
				+ ", user=" + user + "]";
	}
	
	
}
