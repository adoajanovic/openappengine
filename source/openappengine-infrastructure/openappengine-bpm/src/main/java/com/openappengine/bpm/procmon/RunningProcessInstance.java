/**
 * 
 */
package com.openappengine.bpm.procmon;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class RunningProcessInstance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Unique ID assigned to the Running <code>ProcessInstance</code>
	 */
	private String pid;
	
	/**
	 *  <code>ProcessStatus</code> of this process running in the ProcessEngine.
	 */
	private ProcessStatus processStatus;

	/**
	 * Default Constructor
	 */
	public RunningProcessInstance() {
		pid = PIDGenerator.newProcessId();
		processStatus = new ProcessStatus();
	}

	//Accessors
	public String getPid() {
		return pid;
	}

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

}
