/**
 * 
 */
package com.openappengine.fms.interfaces;

/**
 * @author hrishikesh.joshi
 *
 */
public class FleetManagerServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public FleetManagerServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public FleetManagerServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public FleetManagerServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FleetManagerServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
