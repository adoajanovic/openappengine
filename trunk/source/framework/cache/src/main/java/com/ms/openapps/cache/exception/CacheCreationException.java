/**
 * 
 */
package com.ms.openapps.cache.exception;

/**
 * @author hrishi
 *
 */
public class CacheCreationException extends Exception{

	private static final long serialVersionUID = 1L;

	public CacheCreationException(String msg, Throwable t) {
		super(msg, t);
	}

	public CacheCreationException(String msg) {
		super(msg);
	}
	
}
