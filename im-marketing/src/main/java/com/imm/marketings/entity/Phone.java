package com.imm.marketings.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long phoneNumber;

	private long countryKey;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Person person;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Company company;

}
