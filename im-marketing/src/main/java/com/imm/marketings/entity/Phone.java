package com.imm.marketings.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "phone", uniqueConstraints = @UniqueConstraint(columnNames = { "phoneNumber" }))
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long phoneNumber;

	private long countryKey;

	private String zone;

//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "phone")
//	private Company company;
//
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "phone")
//	private Client client;
//
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "phone")
//	private Person person;

}
