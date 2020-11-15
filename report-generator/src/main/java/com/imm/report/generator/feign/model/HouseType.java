package com.imm.report.generator.feign.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseType {

	private long id;

	private String houseTypeName;

	private List<Address> addresses;
}
