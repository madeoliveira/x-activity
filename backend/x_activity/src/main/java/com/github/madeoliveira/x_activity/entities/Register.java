package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_register")
public class Register implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 8,max = 11,message = "Deve ter no máximo {max} caraquiteres. " + "Você digitou " + "${validatedValue}" )
	private String cpf;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 8,max = 11,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String rg;
	@NotNull(message = "Campo obrigatório!")
	@Size(max = 25,message = "Deve ter no máximo {max} caracteres." + "Você digitou " + "${validatedValue}" )
	private String street;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 4,max = 15,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String city;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 4,max = 15,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String state;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 1,max = 9,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String gender;

	@JsonIgnore
	@OneToOne
	@MapsId
	@JoinColumn(name = "client_id")
	private User client;

	public Register() {
	}

	public Register(Long id, String cpf, String rg, String street, String city, String state, String gender,
			User client) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.rg = rg;
		this.street = street;
		this.city = city;
		this.state = state;
		this.gender = gender;
		this.client = client;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		Register other = (Register) obj;
		return Objects.equals(id, other.id);
	}

}