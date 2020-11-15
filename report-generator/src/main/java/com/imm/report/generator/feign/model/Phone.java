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
public class Phone {

	private long id;

	private Long phoneNumber;

	private long countryKey;

	private String zone;

}
