/**
 * 
 */
package com.openappengine.bpm.procmod;


/**
 * @author hrishikesh.joshi
 *
 */
public class History extends Target {

	private Transition transition;
	
	public History(Transition transition) {
		super();
		this.transition = transition;
	}

	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

}
