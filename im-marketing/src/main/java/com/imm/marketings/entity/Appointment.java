package com.imm.marketings.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date appointmentDate;

	private long prix;

	private long tax;

	@JsonIgnoreProperties(value = { "appointments" }, allowSetters = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private AppointmentType appointmentType;


	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "appointment" }, allowSetters = true)
	private Person person;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "appointment" }, allowSetters = true)
	private Client client;
}
