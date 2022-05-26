package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bioimpedance")
public class Bioimpedance  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double PercFat;
	private Double PercLleanMass;
	private Double TotBobyWater;
	private Double BoneMass;
	private Double FatMass;
	private Double FatFreeMass;
	private Double VisceFatIndex;
	private Integer MetabolicAge;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Bioimpedance(){
	}
	
	public Bioimpedance(Long id, Double percFat, Double percLleanMass,
			Double totBobyWater, Double boneMass, Double fatMass, Double fatFreeMass, Double visceFatIndex,
			Integer metabolicAge, User client) {
		super();
		this.id = id;
		this.PercFat = percFat;
		this.PercLleanMass = percLleanMass;
		this.TotBobyWater = totBobyWater;
		this.BoneMass = boneMass;
		this.FatMass = fatMass;
		this.FatFreeMass = fatFreeMass;
		this.VisceFatIndex = visceFatIndex;
		this.MetabolicAge = metabolicAge;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPercFat() {
		return PercFat;
	}

	public void setPercFat(Double percFat) {
		PercFat = percFat;
	}

	public Double getPercLleanMass() {
		return PercLleanMass;
	}

	public void setPercLleanMass(Double percLleanMass) {
		PercLleanMass = percLleanMass;
	}

	public Double getTotBobyWater() {
		return TotBobyWater;
	}

	public void setTotBobyWater(Double totBobyWater) {
		TotBobyWater = totBobyWater;
	}

	public Double getBoneMass() {
		return BoneMass;
	}

	public void setBoneMass(Double boneMass) {
		BoneMass = boneMass;
	}

	public Double getFatMass() {
		return FatMass;
	}

	public void setFatMass(Double fatMass) {
		FatMass = fatMass;
	}

	public Double getFatFreeMass() {
		return FatFreeMass;
	}

	public void setFatFreeMass(Double fatFreeMass) {
		FatFreeMass = fatFreeMass;
	}

	public Double getVisceFatIndex() {
		return VisceFatIndex;
	}

	public void setVisceFatIndex(Double visceFatIndex) {
		VisceFatIndex = visceFatIndex;
	}

	public Integer getMetabolicAge() {
		return MetabolicAge;
	}

	public void setMetabolicAge(Integer metabolicAge) {
		MetabolicAge = metabolicAge;
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