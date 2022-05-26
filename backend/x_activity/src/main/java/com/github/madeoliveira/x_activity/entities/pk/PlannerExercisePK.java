package com.github.madeoliveira.x_activity.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.github.madeoliveira.x_activity.entities.Exercise;
import com.github.madeoliveira.x_activity.entities.Planner;

@Embeddable
public class PlannerExercisePK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "planner_id")
	private Planner planner;
	@ManyToOne
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;
	
	public Planner getPlanner() {
		return planner;
	}
	public void setPlanner(Planner planner) {
		this.planner = planner;
	}
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	@Override
	public int hashCode() {
		return Objects.hash(exercise, planner);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlannerExercisePK other = (PlannerExercisePK) obj;
		return Objects.equals(exercise, other.exercise) && Objects.equals(planner, other.planner);
	}
	
	
	
}
