package com.imm.auth.model;

import lombok.Data;

@Data
public class PasswordModel {

	private long id;
	private String oldPassword;
	private String newPassword;
}