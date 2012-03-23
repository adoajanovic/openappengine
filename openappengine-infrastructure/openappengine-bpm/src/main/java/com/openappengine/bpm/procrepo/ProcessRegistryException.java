/**
 * 
 */
package com.openappengine.bpm.procrepo;

/**
 * @author hrishi
 *
 */
public class ProcessRegistryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProcessRegistryException() {
	}

	/**
	 * @param message
	 */
	public ProcessRegistryException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ProcessRegistryException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProcessRegistryException(String message, Throwable cause) {
		super(message, cause);
	}

}