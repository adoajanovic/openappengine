package com.openappengine.bpm.state;

import java.util.Map;

import javolution.util.FastMap;

public class StateChartContext {
	
	/* A List of all the States */
	private Map<String, State> stateMap;
	
	/* Initial State */
	private State initialState;
	
	/* Running State */
	private RunningStateInfo runningStateInfo;
	
	public State getState(String stateId) {
		isStatePresent(stateId);
		return stateMap.get(stateId);
	}

	/**
	 * @param stateId
	 * @throws StateNotFoundException
	 */
	private void isStatePresent(String stateId) throws StateNotFoundException {
		if(!stateMap.containsKey(stateId)) {
			throw new StateNotFoundException("State : [" + stateId + " ] not found in the State Chart!");
		}
	}

	public void setStateMap(Map<String, State> stateMap) {
		this.stateMap = stateMap;
	}
	
	/**
	 * @param state
	 * @return true: if state was added to the state chart; else otherwise
	 */
	public boolean addState(State state) {
		if(state == null) {
			return false;
		}
		if(stateMap == null) {
			stateMap = FastMap.newInstance();
		}
		isValidInitialState(state);
		stateMap.put(state.getId(), state);
		return true;
	}

	/**
	 * @param state
	 * @throws NonUniqueInitialStateException
	 */
	private void isValidInitialState(State state)
			throws NonUniqueInitialStateException {
		if(state.isInitialState()) {
			if(initialState != null) {
				throw new NonUniqueInitialStateException(" Initial State Already Configured");
			}
			initialState = state;
		}
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public RunningStateInfo getRunningStateInfo() {
		return runningStateInfo;
	}

	public void setRunningStateInfo(RunningStateInfo runningStateInfo) {
		this.runningStateInfo = runningStateInfo;
	}

}
