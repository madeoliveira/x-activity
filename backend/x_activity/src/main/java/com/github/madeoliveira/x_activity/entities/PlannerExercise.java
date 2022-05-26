package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.madeoliveira.x_activity.entities.pk.PlannerExercisePK;

@Entity
@Table(name = "tb_planner_exercise")
public class PlannerExercise implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlannerExercisePK id = new PlannerExercisePK();
	private Integer sequence;
	private Integer movement;
	private Double load;
	
	public PlannerExercise() {
	}
	public PlannerExercise(Planner planner,Exercise exercise,Integer sequence, Integer movement, Double load) {
		super();
		id.setPlanner(planner);
		id.setExercise(exercise);
		this.sequence = sequence;
		this.movement = movement;
		this.load = load;
	}
	@JsonIgnore
	public Planner getPlanner() {
		return id.getPlanner();
	}
	public void setPlanner(Planner planner) {
		id.setPlanner(planner);
	}
	public Exercise getExercise() {
		return id.getExercise();
	}
	public void setExercise(Exercise exercise) {
		id.setExercise(exercise);
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getMovement() {
		return movement;
	}
	public void setMovement(Integer movement) {
		this.movement = movement;
	}
	public Double getLoad() {
		return load;
	}
	public void setLoad(Double load) {
		this.load = load;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlannerExercise other = (PlannerExercise) obj;
		return Objects.equals(id, other.id);
	}
}
