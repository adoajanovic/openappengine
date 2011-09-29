/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class FinalState extends Process {
	
	/**
	 *  Sets the final state field to True.
	 */
	public FinalState() {
		super();
		this.setFinalProcess(true);
	}

}
