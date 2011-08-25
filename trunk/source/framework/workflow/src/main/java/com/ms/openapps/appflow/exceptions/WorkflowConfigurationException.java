/**
 * 
 */
package com.ms.openapps.appflow.exceptions;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class WorkflowConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final Logger logger = Logger.getLogger(getClass());

	public WorkflowConfigurationException() {
	}

	/**
	 * @param msg
	 */
	public WorkflowConfigurationException(String msg) {
		super(msg);
		logger.error(msg);
	}

	/**
	 * @param t
	 */
	public WorkflowConfigurationException(Throwable t) {
		super(t);
		logger.error(t);
	}

	/**
	 * @param msg
	 * @param t
	 */
	public WorkflowConfigurationException(String msg, Throwable t) {
		super(msg, t);
		logger.error(msg,t);
	}

}
