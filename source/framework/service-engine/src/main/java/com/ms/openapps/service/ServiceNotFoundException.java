/**
 * 
 */
package com.ms.openapps.service;

/**
 * @author hrishi
 *
 */
public class ServiceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ServiceNotFoundException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ServiceNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public ServiceNotFoundException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ServiceNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
