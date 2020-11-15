package com.imm.report.generator.feign.model;

import java.util.Date;
import java.util.Set;

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
public class Person {

	private long id;

	private String firstName;

	private String lastName;

	private Date birthdate;

	private String address;

	private String email;

	private String role;

	private Set<Role> roles;

	private Phone phone;

	private Company company;

	private Set<Appointment> appointments;

}
