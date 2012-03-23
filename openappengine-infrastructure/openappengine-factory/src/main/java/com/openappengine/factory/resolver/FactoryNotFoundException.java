/**
 * 
 */
package com.openappengine.factory.resolver;

/**
 * @author hrishikesh.joshi
 *
 */
public class FactoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FactoryNotFoundException() {
		super();
	}

	public FactoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FactoryNotFoundException(String message) {
		super(message);
	}

	public FactoryNotFoundException(Throwable cause) {
		super(cause);
	}

}
