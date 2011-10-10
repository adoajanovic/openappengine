/**
 * 
 */
package com.openappengine.bpm.procmod;

import java.util.Map;

/**
 * @author hrishi
 *
 */
public class State extends Target {
	
	/*
	 *  A map of child processes. Used if the process has any subprocesses and itself acts as a ProcessEngine itself.
	 */
	private Map<String,State> children;
	
	/**
	 * 	A Set of Parallel Processes to be executed when this {@link State} is triggered.
	 */
	private Parallel parallel;
	
	/**
	 * Invoke an executable process
	 */
	private Invoke invoke;
	
	/**
	 *  Is State Final.
	 */
	private boolean finalState;
	
	/**
	 *  Is Initial State.
	 */
	private boolean initialState;
	
	/**
	 *  Parent State
	 */
	private State parent;
	
	
	/**
     * Check whether this is a simple (leaf) state (UML terminology).
     *
     * @return true if this is a simple state, otherwise false
     */
    public final boolean isSimple() {
        if (parallel == null && children.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Check whether this is a composite state (UML terminology).
     *
     * @return true if this is a composite state, otherwise false
     */
    public final boolean isComposite() {
        if (parallel == null && children.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public State getState(String name) {
    	return children.get(name);
    }
    
	public Map<String,State> getChildren() {
		return children;
	}

	public void setChildren(Map<String,State> children) {
		this.children = children;
	}

	public Parallel getParallel() {
		return parallel;
	}

	public void setParallel(Parallel parallel) {
		this.parallel = parallel;
	}

	public Invoke getInvoke() {
		return invoke;
	}

	public void setInvoke(Invoke invoke) {
		this.invoke = invoke;
	}

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}

	public boolean isFinalState() {
		return finalState;
	}

	public void setFinalState(boolean finalState) {
		this.finalState = finalState;
	}

	public boolean isInitialState() {
		return initialState;
	}

	public void setInitialState(boolean initialState) {
		this.initialState = initialState;
	}
}