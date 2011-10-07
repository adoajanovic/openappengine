/**
 * 	Represents a Single Process Instance.
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 *
 */
public class ProcessInstance implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *  Unique Process Id.
	 */
	private String id;
	
	/**
	 *  The initial state the process would be in.
	 */
	private State initialState;
	
	/**
	 *  The data model for this finite state machine.
	 */
	private DataModel dataModel;
	
	/**
	 *  A map of all the target State's mapped by their Id's.
	 */
	private Map<String, State> stateMap;
	
	/**
	 * Default Constructor. 
	 */
	public ProcessInstance() {
		super();
		stateMap = new HashMap<String, State>();
	}
	
	public void addState(String id, State state) {
		stateMap.put(id, state);
	}
	
	public State getState(String id) {
		State state = stateMap.get(id);
		return state;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * @return the initialState
	 */
	public State getInitialState() {
		return initialState;
	}

	/**
	 * @param initialState the initialState to set
	 */
	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

}
