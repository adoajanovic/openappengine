/**
 * 
 */
package com.ms.openapps.entity.context.exception;

/**
 * @author hrishi
 *
 */
public class EntityContextConfigurationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EntityContextConfigurationException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EntityContextConfigurationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public EntityContextConfigurationException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public EntityContextConfigurationException(Throwable arg0) {
		super(arg0);
	}

}
