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
	
	private static Map<String, RunningProcessInstance> runningProcesses = new HashMap<String, RunningProcessInstance>();
	
	/**
	 * Add the <code>RunningProcess</code> to the ProcessMonitor.
	 * @param runningProcessInstance
	 * @throws ProcessMonitorException 
	 */
	public static void registerNewRunningProcessInstance(RunningProcessInstance runningProcessInstance) throws ProcessMonitorException { 
		if(runningProcessInstance == null) {
			throw new ProcessMonitorException("New Instance found to be null..");
		}
		runningProcesses.put(runningProcessInstance.getPid(), runningProcessInstance);
	}
	
	/**
	 * Get the running process instance by its pid.
	 * @param pid
	 * @return {@link RunningProcessInstance}
	 */
	public static RunningProcessInstance getRunningProcessInstanceByPid(String pid) {
		return runningProcesses.get(pid);
	}
	
	/**
	 * Update the <code>ProcessStatus</code> of the ProcessInstance specified by its pid.
	 * @param pid
	 * @param processStatus
	 * @throws ProcessMonitorException
	 */
	public static void updateRunningProcessInstanceStatusByPid(String pid,ProcessStatus processStatus) throws ProcessMonitorException {
		validateRunningProcessInstance(pid);
		RunningProcessInstance runningProcessInstance = runningProcesses.get(pid);
		runningProcessInstance.setProcessStatus(processStatus);
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
		RunningProcessInstance runningProcessInstance = runningProcesses.get(pid);
		runningProcesses.remove(runningProcessInstance);
	}

}
