/**
 * 
 */
package com.openappengine.bpm.workflow;

/**
 * @author hrishi
 *
 */
public final class WorkflowRouterException extends Exception {

	private static final long serialVersionUID = 1L;

	public WorkflowRouterException() {
	}

	/**
	 * @param message
	 */
	public WorkflowRouterException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public WorkflowRouterException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WorkflowRouterException(String message, Throwable cause) {
		super(message, cause);
	}

}
