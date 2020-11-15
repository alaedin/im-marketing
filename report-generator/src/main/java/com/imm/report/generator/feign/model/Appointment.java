package com.imm.report.generator.feign.model;

import java.util.Date;

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
public class Appointment {

	private long id;

	private Date appointmentDate;

	private long prix;

	private long tax;

	private AppointmentType appointmentType;

	private Person person;

	private Client client;
}
