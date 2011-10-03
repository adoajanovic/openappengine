/**
 * 	Processes to be executed in parallel when the parent process is triggered.
 */
package com.openappengine.bpm.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
public class Parallel extends Target {

	private Set<State> states;
	
	public void addParellelState(State state) {
		if(state == null) {
			return;
		}
		
		if(getStates() == null) {
			setStates(new HashSet<State>());
		}
		
		getStates().add(state);
	}

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}


}
