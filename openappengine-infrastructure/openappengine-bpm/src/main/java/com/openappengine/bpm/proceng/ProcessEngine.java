/**
 * 
 */
package com.openappengine.bpm.proceng;

import com.openappengine.bpm.procexec.IExecutionService;

/**
 * @author hrishi
 *
 */
public class ProcessEngine {
	
	/**
	 *  <code>IExecutionService</code> 
	 */
	private IExecutionService iExecutionService;
	
	

	/**
	 * @return the iExecutionService
	 */
	public IExecutionService getProcessExecutionService() {
		return iExecutionService;
	}

	/**
	 * @param iExecutionService the iExecutionService to set
	 */
	public void setProcessExecutionService(IExecutionService iExecutionService) {
		this.iExecutionService = iExecutionService;
	}

}
