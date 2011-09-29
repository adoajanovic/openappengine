/**
 * 
 */
package com.openappengine.bpm.model;

import java.util.Map;

/**
 * @author hrishi
 *
 */
public class Process {
	
	/**
	 *  Process Name
	 */
	private String processName;
	
	/*
	 *  A map of child processes. Used if the process has any subprocesses and itself acts as a ProcessEngine itself.
	 */
	private Map<String,Process> children;
	
	/**
	 * 	A Set of Parallel Processes to be executed when this {@link Process} is triggered.
	 */
	private Parallel parallel;
	
	/**
	 * Invoke an executable process
	 */
	private Invoke invoke;
	
	/**
	 *  Is Process Final.
	 */
	private boolean finalProcess;
	
	/**
	 *  Is Initial Process.
	 */
	private boolean initialProcess;
	
	/**
	 *  Parent Process
	 */
	private Process parent;
	
	
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
    
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Map<String,Process> getChildren() {
		return children;
	}

	public void setChildren(Map<String,Process> children) {
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

	public boolean isFinalProcess() {
		return finalProcess;
	}

	public void setFinalProcess(boolean finalProcess) {
		this.finalProcess = finalProcess;
	}

	public boolean isInitialProcess() {
		return initialProcess;
	}

	public void setInitialProcess(boolean initialProcess) {
		this.initialProcess = initialProcess;
	}

	public Process getParent() {
		return parent;
	}

	public void setParent(Process parent) {
		this.parent = parent;
	}
}