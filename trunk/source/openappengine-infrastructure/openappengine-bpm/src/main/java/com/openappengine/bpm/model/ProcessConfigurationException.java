/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishi
 *
 */
public class ProcessConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ProcessConfigurationException() {
	}

	/**
	 * @param message
	 */
	public ProcessConfigurationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ProcessConfigurationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProcessConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

}