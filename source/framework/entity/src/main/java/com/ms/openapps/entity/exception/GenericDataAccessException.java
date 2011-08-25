/**
 * 
 */
package com.ms.openapps.entity.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author hrishi
 *
 */
public class GenericDataAccessException extends DataAccessException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param msg
	 */
	public GenericDataAccessException(String msg) {
		super(msg);
	}

	/**
	 * @param msg
	 * @param cause
	 */
	public GenericDataAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}