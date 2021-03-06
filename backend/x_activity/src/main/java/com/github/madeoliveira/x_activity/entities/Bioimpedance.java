package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_bioimpedance")
public class Bioimpedance  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	@NotNull(message = "Campo obrigatório!")
	private Double percFat;
	@NotNull(message = "Campo obrigatório!")
	private Double percLleanMass;
	@NotNull(message = "Campo obrigatório!")
	private Double totBobyWater;
	@NotNull(message = "Campo obrigatório!")
	private Double boneMass;
	@NotNull(message = "Campo obrigatório!")
	private Double fatMass;
	@NotNull(message = "Campo obrigatório!")
	private Double fatFreeMass;
	@NotNull(message = "Campo obrigatório!")
	private Double visceralFatIndex;
	@NotNull(message = "Campo obrigatório!")
	private Integer metabolicAge;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Bioimpedance(){
	}
	
	public Bioimpedance(Long id,Instant moment, Double percFat, Double percLleanMass,
			Double totBobyWater, Double boneMass, Double fatMass, Double fatFreeMass, Double visceralFatIndex, 
			Integer metabolicAge, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.percFat = percFat;
		this.percLleanMass = percLleanMass;
		this.totBobyWater = totBobyWater;
		this.boneMass = boneMass;
		this.fatMass = fatMass;
		this.fatFreeMass = fatFreeMass;
		this.visceralFatIndex = visceralFatIndex;
		this.metabolicAge = metabolicAge;
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

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public Double getPercFat() {
		return percFat;
	}

	public void setPercFat(Double percFat) {
		this.percFat = percFat;
	}

	public Double getPercLleanMass() {
		return percLleanMass;
	}

	public void setPercLleanMass(Double percLleanMass) {
		this.percLleanMass = percLleanMass;
	}

	public Double getTotBobyWater() {
		return totBobyWater;
	}

	public void setTotBobyWater(Double totBobyWater) {
		this.totBobyWater = totBobyWater;
	}

	public Double getBoneMass() {
		return boneMass;
	}

	public void setBoneMass(Double boneMass) {
		this.boneMass = boneMass;
	}

	public Double getFatMass() {
		return fatMass;
	}

	public void setFatMass(Double fatMass) {
		this.fatMass = fatMass;
	}

	public Double getFatFreeMass() {
		return fatFreeMass;
	}

	public void setFatFreeMass(Double fatFreeMass) {
		this.fatFreeMass = fatFreeMass;
	}

	public Double getVisceralFatIndex() {
		return visceralFatIndex;
	}

	public void setVisceralFatIndex(Double visceralFatIndex) {
		this.visceralFatIndex = visceralFatIndex;
	}

	public Integer getMetabolicAge() {
		return metabolicAge;
	}

	public void setMetabolicAge(Integer metabolicAge) {
		this.metabolicAge = metabolicAge;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Bioimpedance other = (Bioimpedance) obj;
		return Objects.equals(id, other.id);
	}


	

	

}