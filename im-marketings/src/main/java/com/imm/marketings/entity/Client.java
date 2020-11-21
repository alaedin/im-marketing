package com.imm.marketings.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Client {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthdate;
	
	private String address;
	
	@Email
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Phone phone;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
	@JsonIgnore // (value={ "appointment" }, allowSetters= true)
	private Appointment appointment;
	
}
