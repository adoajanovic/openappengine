/**
 * 
 */
package com.ms.openapps.appflow.exceptions;

/**
 * @author hrishi
 *
 */
public class AppFlowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppFlowException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppFlowException(String message) {
		super(message);
	}

}
