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
	 *  <code>ExecutionService</code> 
	 */
	private ExecutionService executionService;
	
	

	/**
	 * @return the executionService
	 */
	public ExecutionService getProcessExecutionService() {
		return executionService;
	}

	/**
	 * @param executionService the executionService to set
	 */
	public void setProcessExecutionService(ExecutionService executionService) {
		this.executionService = executionService;
	}

}
