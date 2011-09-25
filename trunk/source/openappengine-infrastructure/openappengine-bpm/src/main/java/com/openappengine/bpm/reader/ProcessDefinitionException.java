/**
 * 
 */
package com.openappengine.bpm.reader;

/**
 * @author hrishi
 *
 */
public class ProcessDefinitionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProcessDefinitionException() {
		super();
	}

	public ProcessDefinitionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessDefinitionException(String message) {
		super(message);
	}

	public ProcessDefinitionException(Throwable cause) {
		super(cause);
	}

}
