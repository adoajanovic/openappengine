/**
 * 
 */
package com.openappengine.gui.engine.fsm;

import java.util.List;

/**
 * @author hrishikesh.joshi
 * @since Dec 28, 2011
 */
public class TransitionContext {

	private List<Transition> transitions;
	
	public TransitionContext(List<Transition> transitions) {
		this.setTransitions(transitions);
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	protected void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

}
