package com.imm.marketings.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String companyName;

	@OneToOne
	@JsonIgnoreProperties(value={ "company" }, allowSetters= true)
	private Address address;

	private String rib;

	private String iban;

	private String codeBic;

	private String description;

	@JsonIgnoreProperties(value={ "company" }, allowSetters= true)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private Set<Person> persons;
	
	@OneToOne
	private Phone phone;

}
