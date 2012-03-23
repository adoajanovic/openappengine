/**
 * 
 */
package com.openappengine.factory;

/**
 * @author hrishikesh.joshi
 *
 */
public class FactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public FactoryException() {
		super();
	}

	public FactoryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FactoryException(String arg0) {
		super(arg0);
	}

	public FactoryException(Throwable arg0) {
		super(arg0);
	}

}
