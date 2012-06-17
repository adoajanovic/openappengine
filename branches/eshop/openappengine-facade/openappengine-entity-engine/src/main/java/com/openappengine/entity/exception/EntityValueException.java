/**
 * 
 */
package com.openappengine.entity.exception;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityValueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EntityValueException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public EntityValueException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public EntityValueException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EntityValueException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
