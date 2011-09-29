/**
 * 
 */
package com.openappengine.bpm.api;

/**
 * @author hrishikesh.joshi
 *
 */
public interface IErrorReporter {
	
	
	/**
	 * Provided as an Adapter to handle the Error Event/s. 
	 * @param errorCode - Error Code
	 * @param errorDescription - Error Description 
	 * @param target - The target which caused the error.
	 */
	public void onErrorEvent(String errorCode, String errorDescription, Object target);

}
