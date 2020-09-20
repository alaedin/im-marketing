package com.imm.marketings.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Person {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private Date brithdate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PersonRole personRole;
	
	@OneToMany(mappedBy = "person")
	private List<PersonAppointment> personAppointments;
	
	@OneToMany
	private List<Phone> phones;
}
