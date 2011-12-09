/**
 * 
 */
package com.openappengine.facade.entity.definition;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinitionReaderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EntityDefinitionReaderException() {
		
	}

	/**
	 * @param message
	 */
	public EntityDefinitionReaderException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public EntityDefinitionReaderException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public EntityDefinitionReaderException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
