package com.github.madeoliveira.x_activity.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 3,max = 30,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String name;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 5,max = 30,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou " + "${validatedValue}" )
	private String email;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 5,max = 15,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " + "Você digitou "+"${validatedValue}" )
	private String phone;
	@NotNull(message = "Campo obrigatório!")
	@Size(min = 4,max = 8,message = "Deve ter no máximo {max} caracteres e no minimo {min} caracteres " )
	private String password;

	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Planner> planners = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Bioimpedance> bioimpedances = new ArrayList<>();
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Register register;

	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Planner> getPlanners() {
		return planners;
	}
	public List<Bioimpedance> getBioimpedances() {
		return bioimpedances;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
