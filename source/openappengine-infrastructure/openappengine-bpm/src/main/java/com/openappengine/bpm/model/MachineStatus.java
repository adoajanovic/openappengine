/**
 *  <b>MachineCode</b> encapsulates the overall state of the State Machine.
 */
package com.openappengine.bpm.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
public class MachineStatus {
	
	/**
	 *  The States of the State Machine which are currently active.
	 */
	private Set<? extends State> activeStates;
	
	/**
	 *  Events that are queued.
	 */
	private List<Event> queuedEvents;
	
	/**
	 *  For a StateMachine in Init State, the Active States and the Queued Events will be empty.
	 *  Default Constructor.
	 */
	public MachineStatus() {
		activeStates = new HashSet<State>();
		queuedEvents = new ArrayList<Event>();
	}
	
	public Set<? extends State> getActiveStates() {
		return activeStates;
	}

	public void setActiveStates(Set<? extends State> activeStates) {
		this.activeStates = activeStates;
	}

	public List<Event> getQueuedEvents() {
		return queuedEvents;
	}

	public void setQueuedEvents(List<Event> queuedEvents) {
		this.queuedEvents = queuedEvents;
	}
	
	/**
	 * @return boolean - Is the <b>StateMachine</b> in an init state.
	 */
	public boolean isInitState() {
		if(activeStates.isEmpty() && queuedEvents.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
