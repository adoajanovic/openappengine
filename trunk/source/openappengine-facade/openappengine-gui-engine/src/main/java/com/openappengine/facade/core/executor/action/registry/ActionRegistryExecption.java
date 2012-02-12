/**
 * 
 */
package com.openappengine.facade.core.executor.action.registry;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class ActionRegistryExecption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ActionRegistryExecption() {
		super();
	}

	public ActionRegistryExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public ActionRegistryExecption(String message) {
		super(message);
	}

	public ActionRegistryExecption(Throwable cause) {
		super(cause);
	}
	
}
