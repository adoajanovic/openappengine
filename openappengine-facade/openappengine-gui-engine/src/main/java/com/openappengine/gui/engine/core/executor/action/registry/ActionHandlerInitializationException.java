/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.registry;

/**
 * @author hrishikesh.joshi
 * @since  Feb 7, 2012
 *
 */
public class ActionHandlerInitializationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ActionHandlerInitializationException() {
		
	}

	/**
	 * @param message
	 */
	public ActionHandlerInitializationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ActionHandlerInitializationException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ActionHandlerInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

}
