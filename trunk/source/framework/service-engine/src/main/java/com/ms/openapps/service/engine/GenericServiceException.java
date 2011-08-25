/**
 * 
 */
package com.ms.openapps.service.engine;

/**
 * @author hrishi
 *
 */
public class GenericServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GenericServiceException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public GenericServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public GenericServiceException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public GenericServiceException(Throwable arg0) {
		super(arg0);
	}
	
}
