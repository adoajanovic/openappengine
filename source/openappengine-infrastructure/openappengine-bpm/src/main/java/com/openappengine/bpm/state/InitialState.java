/**
 * 
 */
package com.openappengine.bpm.state;

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
	}

}
