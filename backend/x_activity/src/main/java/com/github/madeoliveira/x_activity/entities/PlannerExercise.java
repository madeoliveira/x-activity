package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.madeoliveira.x_activity.entities.pk.PlannerExercisePK;

@Entity
@Table(name = "tb_planner_exercise")
public class PlannerExercise implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlannerExercisePK id = new PlannerExercisePK();
	@NotNull(message = "Campo obrigatório!")
	private Integer sequence;
	@NotNull(message = "Campo obrigatório!")
	private Integer movement;
	@NotNull(message = "Campo obrigatório!")
	private Double cargo;
	@NotNull(message = "Campo obrigatório!")
	@Size(max = 20, message = "Deve ter no máximo {max} caraquiteres. " + "Você digitou " + "${validatedValue}")
	private String training;
	
	public PlannerExercise() {
	}
	public PlannerExercise(Planner planner,Exercise exercise,Integer sequence, Integer movement, Double cargo, String training) {
		super();
		id.setPlanner(planner);
		id.setExercise(exercise);
		this.sequence = sequence;
		this.movement = movement;
		this.cargo = cargo;
		this.training = training;
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
	public Double getCargo() {
		return cargo;
	}
	public void setCargo(Double cargo) {
		this.cargo =cargo;
	}
	
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
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
