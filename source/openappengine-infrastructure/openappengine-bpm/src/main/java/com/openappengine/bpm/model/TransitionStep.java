/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
public class TransitionStep implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private MachineStatus currentStatus;
	
	private Set<State> statesEntered;
	
	private Set<State> statesExit;
	
	/**
	 *  Default Constructor.
	 */
	public TransitionStep(MachineStatus machineStatus) {
		statesEntered = new HashSet<State>();
		statesExit = new HashSet<State>();
		this.currentStatus = machineStatus;
	}

	public MachineStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(MachineStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Set<State> getStatesEntered() {
		return statesEntered;
	}

	public void setStatesEntered(Set<State> statesEntered) {
		this.statesEntered = statesEntered;
	}

	public Set<State> getStatesExit() {
		return statesExit;
	}

	public void setStatesExit(Set<State> statesExit) {
		this.statesExit = statesExit;
	}

}
