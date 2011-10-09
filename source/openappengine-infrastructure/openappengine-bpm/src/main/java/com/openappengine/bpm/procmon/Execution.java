/**
 * 
 */
package com.openappengine.bpm.procmon;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class Execution implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  This is a state between creation of a new process instance and the start of that process instance. 
	 *  Typically this is only a very short period that is not observable thourgh the service interfaces.
	 */
	public static final String STATE_CREATED = "created";
	
	/**
	 *  Indicates that this execution has ended.
	 */
	public static final String STATE_ENDED = "ended";
	
	/**
	 * Indicates that this execution is temporary suspended. 
	 * Human tasks of a suspended execution shouldn't show up in people's task list 
	 * and timers of suspended executions shouldn't fire and the execution is locked. 
	 */
	public static final String STATE_SUSPENDED = "suspended";
	
	/**
	 *  Indicates that the state is active. 
	 */
	public static final String STATE_ACTIVE_ROOT = "active-root";
	
	/**
	 *  Unique ID assigned to the Running <code>ProcessDefinition</code>
	 */
	protected String pid;
	
	/**
	 *  Current State
	 */
	private String state;
	
	
	//Accessors
	public String getPid() {
		return pid;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
