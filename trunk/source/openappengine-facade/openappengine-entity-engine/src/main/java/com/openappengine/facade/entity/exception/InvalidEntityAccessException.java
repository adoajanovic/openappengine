/**
 * 
 */
package com.openappengine.facade.entity.exception;

/**
 * @author hrishikesh.joshi
 *
 */
public class InvalidEntityAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEntityAccessException() {
		super();
		
	}

	public InvalidEntityAccessException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidEntityAccessException(String message) {
		super(message);
		
	}

	public InvalidEntityAccessException(Throwable cause) {
		super(cause);
		
	}
}
