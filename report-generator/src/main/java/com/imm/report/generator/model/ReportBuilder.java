package com.imm.report.generator.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportBuilder {

	private List<?> values;
	private Map<String, Object> parameters;
	private String jrcmlClasspath;
	
	

}
