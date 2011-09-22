/**
 * 
 */
package com.openappengine.bpm.state;

/**
 * @author hrishikesh.joshi
 *
 */
public class FinalState extends State {
	
	/**
	 *  Sets the final state field to True.
	 */
	public FinalState() {
		super();
		this.setFinalState(true);
	}

}
