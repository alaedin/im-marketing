package com.imm.report.generator.feign.model;

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
public class Company {

	private long id;

	private String companyName;

	private Address address;

	private String rib;

	private String iban;

	private String codeBic;

	private String description;

	private Set<Person> persons;
	
	private Phone phone;

}
