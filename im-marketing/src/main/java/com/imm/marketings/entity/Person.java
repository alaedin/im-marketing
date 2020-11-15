package com.imm.marketings.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;

	private String lastName;

	private Date birthdate;

	private String address;

	@Email
	private String email;

	private String role;

	@ManyToMany
	@JoinTable(name = "pivot_person_role", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	@JsonIgnore
	private Set<Role> roles;

	@OneToOne(cascade = CascadeType.ALL)
	private Phone phone;

	@JsonIgnoreProperties(value = { "persons" }, allowSetters = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
	@JsonIgnore // (value = { "appointments" }, allowSetters = true)
	private Set<Appointment> appointments;

}
