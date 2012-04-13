/**
 * 
 */
package com.openappengine.repository;

/**
 * @author hrishikesh.joshi
 *
 */
public class GenericRepositoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GenericRepositoryException() {
		
	}

	/**
	 * @param message
	 */
	public GenericRepositoryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public GenericRepositoryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public GenericRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}
