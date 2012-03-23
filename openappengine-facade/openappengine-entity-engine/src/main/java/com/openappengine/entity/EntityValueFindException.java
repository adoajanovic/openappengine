/**
 * 
 */
package com.openappengine.entity;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
public class EntityValueFindException extends Exception {

	public EntityValueFindException() {
	}

	/**
	 * @param message
	 */
	public EntityValueFindException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public EntityValueFindException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EntityValueFindException(String message, Throwable cause) {
		super(message, cause);
	}

}