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
public class Target {
	
	/**
	 *  Optional Data Model to be associated
	 */
	private DataModel dataModel;
	
	/**
	 *  Id
	 */
	private String id;
	
	/**
	 *  Parent of this target. Is Null for the root.
	 */
	private Target parent;
	
	/**
	 *  A history of states owned by the Target.
	 */
	private List<History> history = new ArrayList<History>();
	
	/**
	 *  Outgoing transitions from this target.
	 */
	private List<Transition> transitions = new ArrayList<Transition>();
	
	/**
	 *  Transition Map.
	 */
	private Map<String, List<Transition>> transitionMap = new HashMap<String, List<Transition>>();

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
		
		//Add outgoing transition to the Model Map.
		List<Transition> list;
		if(transitionMap.containsKey(transition.getEvent())) {
			list = transitionMap.get(transition.getEvent());
			list.add(transition);
		} else {
			list = new ArrayList<Transition>();
		}
		transitionMap.put(transition.getEvent(), transitions);
	}
	
	/**
	 * Add the transition history to this State.
	 * @param history
	 */
	public void addHistory(History history) {
		if(history == null) {
			return;
		}
		
		history.setParent(this);
		
		this.history.add(history);
	}
	
	
	public List<Transition> getTransitions(String eventName) { 
		return transitionMap.get(eventName);
	}
	
	/**
	 * @param eventName
	 * @return boolean - Whether the Target has any transitions waiting for the input event.
	 */
	public boolean containsTransitionsWaitingForEvent(String eventName) {
		return transitionMap.containsKey(eventName);
	}
	
	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Target getParent() {
		return parent;
	}

	public void setParent(Target parent) {
		this.parent = parent;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

}
