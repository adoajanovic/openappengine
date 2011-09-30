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
public class MachineState {
	
	/**
	 *  The States of the State Machine which are currently active.
	 */
	private Set<? extends State> activeStates;
	
	/**
	 *  Events that are queued.
	 */
	private List<Event> queuedEvents;
	
	/**
	 *  Default Constructor.
	 */
	public MachineState() {
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
	
}
