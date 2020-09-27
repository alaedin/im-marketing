/**
 * 
 */
package com.imm.marketings.exception;

/**
 * @author alaeddine
 *
 */

public class ApiRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -76828599961833139L;
	
	private String message;
    private String body;

    protected ApiRequestException() {
    }

	public ApiRequestException(String message, String body) {
		this.message = message;
		this.body = body;
	}

	public ApiRequestException(String message) {
		this.message = message;
		this.body = null;
	}
	
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}