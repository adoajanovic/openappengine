/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class StateNotFoundException extends IllegalArgumentException {

	public StateNotFoundException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
