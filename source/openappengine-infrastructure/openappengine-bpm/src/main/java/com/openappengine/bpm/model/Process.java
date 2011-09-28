/**
 * 
 */
package com.openappengine.bpm.model;

import java.util.Map;

/**
 * @author hrishi
 *
 */
public class Process implements Executable {
	
	/**
	 *  Process Name
	 */
	private String processName;
	
	/*
	 *  A map of child processes.
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
}