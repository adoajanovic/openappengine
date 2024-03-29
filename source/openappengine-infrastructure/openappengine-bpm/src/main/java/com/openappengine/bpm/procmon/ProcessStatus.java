/**
 *  <b>MachineCode</b> encapsulates the overall state of the State Machine.
 */
package com.openappengine.bpm.procmon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.openappengine.bpm.event.Event;
import com.openappengine.bpm.graph.State;

/**
 * @author hrishikesh.joshi
 *
 */
public class ProcessStatus {
	
	/**
	 *  The States of the State Machine which are currently active.
	 */
	private Set<State> activeStates;
	
	/**
	 *  Events that are queued.
	 */
	private List<Event> queuedEvents;
	
	/**
	 *  For a ProcessDefinition in Init State, the Active States and the Queued Events will be empty.
	 *  Default Constructor.
	 */
	public ProcessStatus() {
		activeStates = new HashSet<State>();
		queuedEvents = new ArrayList<Event>();
	}
	
	public Set<? extends State> getActiveStates() {
		return activeStates;
	}

	public void setActiveStates(Set<State> activeStates) {
		this.activeStates = activeStates;
	}

	public List<Event> getQueuedEvents() {
		return queuedEvents;
	}

	public void setQueuedEvents(List<Event> queuedEvents) {
		this.queuedEvents = queuedEvents;
	}
	
	/**
	 * @return boolean - Is the <b>ProcessDefinition</b> in an init state.
	 */
	public boolean isInitState() {
		if(activeStates.isEmpty() && queuedEvents.isEmpty()) {
			return true;
		}
		return false;
	}
	
}
