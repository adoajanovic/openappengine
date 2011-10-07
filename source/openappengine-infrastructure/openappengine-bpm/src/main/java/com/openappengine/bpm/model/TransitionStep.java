/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class TransitionStep implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  The Transitions taken during this step.
	 */
	private List<Transition> transitions;
	
	/**
	 *  Targets Entered
	 */
	private List<Target> targetsEntered;
	
	/**
	 *  Targets Exit
	 */
	private List<Target> targetsExit;
	
	private ProcessStatus processStatus;
	
	public TransitionStep(ProcessStatus processStatus) {
		super();
		this.processStatus = processStatus;
	}

	//Accessors
	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public List<Target> getTargetsEntered() {
		return targetsEntered;
	}

	public void setTargetsEntered(List<Target> targetsEntered) {
		this.targetsEntered = targetsEntered;
	}

	public List<Target> getTargetsExit() {
		return targetsExit;
	}

	public void setTargetsExit(List<Target> targetsExit) {
		this.targetsExit = targetsExit;
	}
}
