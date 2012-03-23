package com.openappengine.service.api;

/**
 * 
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public class ServiceDispatcherException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceDispatcherException() {
	}

	public ServiceDispatcherException(String message) {
		super(message);
	}

	public ServiceDispatcherException(Throwable cause) {
		super(cause);
	}

	public ServiceDispatcherException(String message, Throwable cause) {
		super(message, cause);
	}

}
