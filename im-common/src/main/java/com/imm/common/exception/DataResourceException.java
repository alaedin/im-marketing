package com.imm.common.exception;

public class DataResourceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8211819890224589276L;
	
	public DataResourceException() {
		super();
	}

	
	public DataResourceException(String message){
		super(message);
	}
	
	public DataResourceException(Throwable cause) {
		super(cause);
	}
	
	public DataResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
