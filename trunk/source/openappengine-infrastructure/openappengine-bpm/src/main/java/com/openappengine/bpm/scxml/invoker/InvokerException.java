/**
 * 
 */
package com.openappengine.bpm.scxml.invoker;

/**
 * @author hrishikesh.joshi
 *
 */
public class InvokerException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvokerException() {
	}

	/**
	 * @param message
	 */
	public InvokerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvokerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvokerException(String message, Throwable cause) {
		super(message, cause);
	}

}