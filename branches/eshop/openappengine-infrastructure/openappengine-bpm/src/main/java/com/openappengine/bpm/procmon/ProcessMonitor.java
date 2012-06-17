/**
 * 
 */
package com.openappengine.bpm.procmon;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hrishi
 *
 */
public class ProcessMonitor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Map<String, ProcessInstance> runningProcesses = new HashMap<String, ProcessInstance>();
	
	/**
	 * Add the <code>RunningProcess</code> to the ProcessMonitor.
	 * @param processInstance
	 * @throws ProcessMonitorException 
	 */
	public static void registerNewRunningProcessInstance(ProcessInstance processInstance) throws ProcessMonitorException { 
		if(processInstance == null) {
			throw new ProcessMonitorException("New Instance found to be null..");
		}
		runningProcesses.put(processInstance.getPid(), processInstance);
	}
	
	/**
	 * Get the running process instance by its pid.
	 * @param pid
	 * @return {@link ProcessInstance}
	 */
	public static Execution getRunningProcessInstanceByPid(String pid) {
		return runningProcesses.get(pid);
	}
	
	/**
	 * Update the <code>ProcessStatus</code> of the ProcessDefinition specified by its pid.
	 * @param pid
	 * @param processStatus
	 * @throws ProcessMonitorException
	 */
	public static void updateRunningProcessInstanceStatusByPid(String pid,ProcessStatus processStatus) throws ProcessMonitorException {
		validateRunningProcessInstance(pid);
		ProcessInstance processInstance = runningProcesses.get(pid);
		processInstance.setProcessStatus(processStatus);
	}

	/**
	 * Validates whether the <code>ProcessMonitor</code> contains the pid. 
	 * @param pid
	 * @throws ProcessMonitorException
	 */
	private static void validateRunningProcessInstance(String pid)
			throws ProcessMonitorException {
		if(!runningProcesses.containsKey(pid)) {
			throw new ProcessMonitorException("Process pid:[" + pid +"] not registered with ProcessMonitor!");
		}
	}
	
	/**
	 * Unregister the running process instance from the Process Monitor.
	 * @param pid
	 * @throws ProcessMonitorException
	 */
	public static void unregisterRunningProcessInstance(String pid) throws ProcessMonitorException {
		validateRunningProcessInstance(pid);
		Execution processInstance = runningProcesses.get(pid);
		runningProcesses.remove(processInstance);
	}

}
