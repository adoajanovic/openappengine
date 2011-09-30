/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishikesh.joshi
 *
 */
public class InitialState extends State {
	
	/**
	 *  Set this as initial state
	 */
	public InitialState() {
		super();
		this.setInitialState(true);
		this.setParent(null);
	}

}
