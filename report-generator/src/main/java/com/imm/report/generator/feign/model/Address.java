package com.imm.report.generator.feign.model;

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
public class Address {

	private long id;

	private int zipCode;

	private String country;

	private int houseNumber;

	private String street;

	private HouseType houseType;

	private Company company;

}
