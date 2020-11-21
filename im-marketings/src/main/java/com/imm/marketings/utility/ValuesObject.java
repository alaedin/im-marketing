package com.imm.marketings.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValuesObject<T> {

	private long outCode;

	private String message;

	private T body;

}
