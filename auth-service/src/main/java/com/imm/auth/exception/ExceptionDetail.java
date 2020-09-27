package com.imm.auth.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetail {

	private Date timestamp;
	private String message;
	private String details;
}