package com.imm.marketings.entity;

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
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int zipCode;

	private String country;

	private int houseNumber;

	private String street;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value={ "addresses" }, allowSetters= true)
	private HouseType houseType;

	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")
	@JsonIgnoreProperties(value={ "address" }, allowSetters= true)
	private Company company;

}
