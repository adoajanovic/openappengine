/**
 * 
 */
package com.openappengine.service.api;

/**
 * The base class for all the Exceptions thrown from the ServiceEngine.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ServiceException extends Exception {

	/**
	 * @param string
	 */
	public ServiceException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
