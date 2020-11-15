package com.imm.report.generator.feign.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	private Long id;

	private String roleName;

	private Set<Person> persons;

}