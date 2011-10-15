/**
 * 
 */
package com.openappengine.bpm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.openappengine.bpm.event.Event;

/**
 * @author hrishikesh.joshi
 *
 */
public class Node {
	
	/**
	 *  name
	 */
	private String name;
	
	/**
	 *  Outgoing transitions from this target.
	 */
	private List<Transition> transitions = new ArrayList<Transition>();
	
	/**
	 *  Supported Events.
	 */
	private List<Event> events = new ArrayList<Event>();
	
	/**
	 *  Transition Map.
	 */
	private Map<String, List<Transition>> transitionMap = new HashMap<String, List<Transition>>();
	
	/**
	 *  Supported Event Types
	 */
	protected String[] supportedEventTypes;

	/**
	 * Add the outgoing transition to this state.
	 * @param transition
	 */
	public void addTransition(Transition transition) {
		if(transition == null) {
			return;
		}
		
		transition.setParent(this);
		
		//Add outgoing transitions to the list.
		transitions.add(transition);
	}
	
	public List<Transition> getTransitions(String eventName) { 
		return transitionMap.get(eventName);
	}
	
	/**
	 * @param eventName
	 * @return boolean - Whether the Node has any transitions waiting for the input event.
	 */
	public boolean containsTransitionsWaitingForEvent(String eventName) {
		return transitionMap.containsKey(eventName);
	}
	
	public String getId() {
		return getName();
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add an {@link Event}
	 * @param event
	 */
	public void addEvent(Event event) {
		if(event == null) {
			return;
		}
		
		events.add(event);
	}

	/**
	 * @return the events
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
