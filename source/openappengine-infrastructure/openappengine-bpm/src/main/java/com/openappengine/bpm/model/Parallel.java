/**
 * 	Processes to be executed in parallel when the parent process is triggered.
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
public class Parallel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Set<Process> processes;
	
	public void addParellelProcess(Process process) {
		if(process == null) {
			return;
		}
		
		if(processes == null) {
			processes = new HashSet<Process>();
		}
		
		processes.add(process);
	}

	public Set<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(Set<Process> processes) {
		this.processes = processes;
	}

}
