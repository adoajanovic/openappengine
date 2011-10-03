/**
 * 	Represents a Finite State Machine.
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.openappengine.bpm.bridge.IStateMachineListener;

/**
 * @author hrishikesh.joshi
 *
 */
public class StateMachine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 *	The <code>ListenerRegistry</code> associated with this <code>StateMachine</code> instance.  
	 */
	private ListenerRegistry listenerRegistry;
	
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
	
	/**
	 * 	<code>MachineStatus</code> gives the current state of the StateMachine.
	 */
	private MachineStatus machineStatus;
	
	/**
	 * Default Constructor. 
	 */
	public StateMachine() {
		super();
		stateMap = new HashMap<String, Target>();
		listenerRegistry = new ListenerRegistry();
		machineStatus = new MachineStatus();
	}
	
	/**
	 * Register <code>IStateMachineListener</code> with the <code>StateMachine</code>.
	 * @param listener
	 */
	public void registerListener(IStateMachineListener listener) {
		if(listener == null) {
			return;
		}
		listenerRegistry.addListener(listener);
	}
	
	
	public void addState(String id, State state) {
		stateMap.put(id, state);
	}
	
	public State getState(String id) {
		Target target = stateMap.get(id);
		if (target instanceof State) {
			return (State) target;
		}
		return null;
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

	public MachineStatus getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(MachineStatus machineStatus) {
		this.machineStatus = machineStatus;
	}

}
