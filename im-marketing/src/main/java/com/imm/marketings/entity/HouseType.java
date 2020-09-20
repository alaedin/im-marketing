package com.imm.marketings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class HouseType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String houseTypeName;

	@OneToMany(mappedBy = "houseType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> addresses;
}
