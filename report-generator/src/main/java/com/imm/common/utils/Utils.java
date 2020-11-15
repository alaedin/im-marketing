package com.imm.common.utils;

public class Utils {

	public static String message(String messageController, String valueToHandle) {
		return messageController.replace("{VALUE_TO_HANDLE}", valueToHandle);
	}
	public static String message(String objectName, String message, long valueToHandle) {
		return message.replace("{VALUE_TO_HANDLE}", valueToHandle+"").replace("{OBJECT_NAME}", objectName);
	}
	
}
