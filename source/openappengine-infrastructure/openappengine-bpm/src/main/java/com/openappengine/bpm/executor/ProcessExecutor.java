/**
 * 
 */
package com.openappengine.bpm.executor;

import com.openappengine.bpm.model.Event;
import com.openappengine.bpm.model.ProcessInstance;
import com.openappengine.bpm.model.State;

/**
 * @author hrishi
 *
 */
public class ProcessExecutor implements IProcessExecutor {
	
	/* (non-Javadoc)
	 * @see com.openappengine.bpm.executor.IProcessExecutor#executeProcess(com.openappengine.bpm.model.ProcessInstance)
	 */
	public void startProcess(ProcessInstance processInstance) {
		if(processInstance == null) {
			//TODO - throw exception
		}
		State initialState = processInstance.getInitialState();
		
	}

	public void triggerEvent(ProcessInstance processInstance,Event event) {
		// TODO Auto-generated method stub
	}

}
