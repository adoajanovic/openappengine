/**
 * 
 */
package com.openappengine.bpm.state;

/**
 * @author hrishikesh.joshi
 *
 */
public class NonUniqueInitialStateException extends IllegalStateException {

	public NonUniqueInitialStateException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
