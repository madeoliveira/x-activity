package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.madeoliveira.x_activity.entities.enums.PlannerStatus;

@Entity
@Table(name = "tb_planner")
public class Planner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer plannerStatus;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	@Size(max = 200,message = "Deve ter no máximo {max} caracteres " + "Você digitou " + "${validatedValue}" )
	private String reminder;
	
	@OneToMany(mappedBy = "id.planner")
	private Set<PlannerExercise> exercises = new HashSet<>();

	public Planner() {
	}
	public Planner(Long id, Instant moment, PlannerStatus plannerStatus, String reminder, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setPlannerStatus(plannerStatus);
		this.reminder = reminder;
		this.client = client;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getMoment() {
		return moment;
	}
	public void setMomnet(Instant moment) {
		this.moment = moment;
	}
	public PlannerStatus getPlannerStatus() {
		return PlannerStatus.valueOf(plannerStatus);
	}
	public void setPlannerStatus(PlannerStatus plannerStatus) {
		if (plannerStatus != null) {
			this.plannerStatus = plannerStatus.getCode();
		}
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	public Set<PlannerExercise> getExercises(){
		return exercises;
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
		Planner other = (Planner) obj;
		return Objects.equals(id, other.id);
	}

}
