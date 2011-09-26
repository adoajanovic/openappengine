/**
 * 
 */
package com.openappengine.bpm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishi
 *
 */
public class ProcessModel implements Executable {
	
	private String processName;
	
	private String aggregateRoot;
	
	private ProcessExecutor processExecutor;
	
	private List<State> states;
	
	private List<State> initialStates = new ArrayList<State>();
	
	private int sequenceNo;

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getAggregateRoot() {
		return aggregateRoot;
	}

	public void setAggregateRoot(String aggregateRoot) {
		this.aggregateRoot = aggregateRoot;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	public boolean addState(State state) {
		if(this.states == null) {
			this.states = new ArrayList<State>();
		}
		if(state == null) {
			return false;
		}
		if(state.isInitialState()) {	//If init state is true add to init states.
			initialStates.add(state);
		}
		return states.add(state);
	}

	public ProcessExecutor getProcessExecutor() {
		return processExecutor;
	}

	public void setProcessExecutor(ProcessExecutor processExecutor) {
		this.processExecutor = processExecutor;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
}