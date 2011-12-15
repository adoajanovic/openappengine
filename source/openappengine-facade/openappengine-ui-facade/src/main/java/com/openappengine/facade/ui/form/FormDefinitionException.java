/**
 * 
 */
package com.openappengine.facade.ui.form;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FormDefinitionException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FormDefinitionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FormDefinitionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FormDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

}
