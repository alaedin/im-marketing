package com.imm.utility;

public class Utils {

	public static String successMessage(String messageController, String valueToAdd) {
		return messageController.replace("{}", valueToAdd);
	}

}
