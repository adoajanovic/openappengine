/**
 * 
 */
package com.openappengine.bpm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author hrishikesh.joshi
 *
 */
public class State {
	
	private String id;
	
	private boolean initialState = false;
	
	private boolean finalState = false;
	
	private List<Transition> transitions;
	
	private State parent;
	
	private Map<String, Transition> transitionLookupMap;
	
	public State() {
		transitionLookupMap = new HashMap<String, Transition>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initial) {
		this.initialState = initial;
	}
	
	/**
	 * @param transition
	 * @return true : if transition is added to the state; false otherwise;
	 */
	public boolean addTransition(Transition transition) {
		if(transition == null) {
			return false;
		}
		if(transitions == null) {
			transitions = new ArrayList<Transition>();
		}
		transitionLookupMap.put(transition.getEvent(), transition);
		return transitions.add(transition);
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public boolean isFinalState() {
		return finalState;
	}

	public void setFinalState(boolean finalState) {
		this.finalState = finalState;
	}

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}
}
