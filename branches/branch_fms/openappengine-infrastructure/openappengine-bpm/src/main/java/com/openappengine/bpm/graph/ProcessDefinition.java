/**
 * 	Represents a Single Process Instance.
 */
package com.openappengine.bpm.graph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 *
 */
public class ProcessDefinition implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *  Unique Process Name.
	 */
	private String name;
	
	/**
	 *  The initial state the process would be in.
	 */
	private StartState startState;
	
	/**
	 *  A map of all the target State's mapped by their Id's.
	 */
	private Map<String, Node> nodeMap;
	
	/**
	 *  List of End States.
	 */
	private List<EndState> endStates;
	
	/**
	 * Default Constructor. 
	 */
	public ProcessDefinition() {
		super();
		nodeMap = new HashMap<String, Node>();
	}
	
	public void addState(String id, State state) {
		nodeMap.put(id, state);
	}
	
	public Node getState(String id) {
		Node node = nodeMap.get(id);
		return node;
	}

	/**
	 * @return the startState
	 */
	public StartState getStartState() {
		return startState;
	}

	/**
	 * @param startState the startState to set
	 */
	public void setStartState(StartState startState) {
		this.startState = startState;
	}

	/**
	 * @return the endStates
	 */
	public List<EndState> getEndStates() {
		return endStates;
	}

	/**
	 * @param endStates the endStates to set
	 */
	public void setEndStates(List<EndState> endStates) {
		this.endStates = endStates;
	}

	/**
	 * Add an {@link EndState}
	 * @param endState
	 */
	public void addEndState(EndState endState) {
		if(endState == null) {
			return;
		}
		
		this.endStates.add(endState);
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

}
