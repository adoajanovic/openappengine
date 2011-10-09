/**
 * 
 */
package com.openappengine.bpm.proceng;

/**
 * @author hrishi
 *
 */
public class ProcessEngine {
	
	/**
	 *  <code>ProcessExecutionService</code> 
	 */
	private ProcessExecutionService processExecutionService;
	
	

	/**
	 * @return the processExecutionService
	 */
	public ProcessExecutionService getProcessExecutionService() {
		return processExecutionService;
	}

	/**
	 * @param processExecutionService the processExecutionService to set
	 */
	public void setProcessExecutionService(ProcessExecutionService processExecutionService) {
		this.processExecutionService = processExecutionService;
	}

}
