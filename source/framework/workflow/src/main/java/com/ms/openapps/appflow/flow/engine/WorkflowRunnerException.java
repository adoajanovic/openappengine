/**
 * 
 */
package com.ms.openapps.appflow.flow.engine;

/**
 * @author hrishi
 *
 */
public class WorkflowRunnerException extends Exception{

	private static final long serialVersionUID = 1L;

	public WorkflowRunnerException() {
		super();
	}

	/**
	 * @param msg
	 * @param t
	 */
	public WorkflowRunnerException(String msg, Throwable t) {
		super(msg, t);
	}

	/**
	 * @param msg
	 */
	public WorkflowRunnerException(String msg) {
		super(msg);
	}

}
