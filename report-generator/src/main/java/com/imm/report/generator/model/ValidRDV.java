package com.imm.report.generator.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidRDV {

	private String clientFirstname;
	private String clientLastname;
	private String advisorFirstname;
	private String advisorLastname;
	private String adress;
	private String phoneNumber;
	private String postalCode;
	private String country;
	private String appointmentStatus;
	private long price;
	private LocalDate date;
	
	

	
}
