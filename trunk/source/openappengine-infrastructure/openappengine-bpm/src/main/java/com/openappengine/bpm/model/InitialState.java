/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class InitialState extends Process {
	
	/**
	 *  Set this as initial state
	 */
	public InitialState() {
		super();
		this.setInitialProcess(true);
		this.setParent(null);
	}

}
