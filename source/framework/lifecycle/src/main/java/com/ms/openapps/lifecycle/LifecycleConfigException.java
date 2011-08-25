/**
 * 
 */
package com.ms.openapps.lifecycle;

/**
 * @author hrishi
 *
 */
public class LifecycleConfigException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LifecycleConfigException() {
	}

	/**
	 * @param arg0
	 */
	public LifecycleConfigException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public LifecycleConfigException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public LifecycleConfigException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}