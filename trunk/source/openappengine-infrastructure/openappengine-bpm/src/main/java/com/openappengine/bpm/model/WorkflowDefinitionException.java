/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishi
 *
 */
public class WorkflowDefinitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WorkflowDefinitionException() {
		super();
	}

	public WorkflowDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkflowDefinitionException(String message) {
		super(message);
	}

	public WorkflowDefinitionException(Throwable cause) {
		super(cause);
	}
}
