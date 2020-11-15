package com.imm.report.generator.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientMapper<T> {
	
	private String outCode;
	private String message;
	private T body;
}
