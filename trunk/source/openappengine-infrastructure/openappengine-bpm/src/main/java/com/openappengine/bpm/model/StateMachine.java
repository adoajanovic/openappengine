/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 *
 */
public class StateMachine implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 *  The initial target to be executed.
	 */
	private Target initialTarget;
	
	/**
	 *  The data model for this finite state machine.
	 */
	private DataModel dataModel;
	
	/**
	 *  A map of all the target State's mapped by their Id's.
	 */
	private Map<String, Target> stateMap;
	
	public StateMachine() {
		super();
		stateMap = new HashMap<String, Target>();
	}
	
	public void addState(String id, State state) {
		stateMap.put(id, state);
	}
	
	public State getState(String id) {
		return (State) stateMap.get(id);
	}


	public Target getInitialTarget() {
		return initialTarget;
	}

	public void setInitialTarget(Target initialTarget) {
		this.initialTarget = initialTarget;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

}
