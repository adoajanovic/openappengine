/**
 * 
 */
package com.openappengine.web.exception;

/**
 * @author hrishikesh.joshi
 *
 */
public class ComponentRenderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ComponentRenderException() {
		super();
	}

	public ComponentRenderException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComponentRenderException(String message) {
		super(message);
	}

	public ComponentRenderException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param string
	 * @param type
	 * @param propertyName
	 */
	public ComponentRenderException(String string, Class<?> type, String propertyName) {
		// TODO Auto-generated constructor stub
	}

}
