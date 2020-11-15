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
public class Client {

	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthdate;
	
	private String address;
	
	private String email;
	
	private Phone phone;
	
	private Appointment appointment;
	
}
