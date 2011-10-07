/**
 * Called by the ProcessExecutionService.
 */
package com.openappengine.bpm.executor;

import com.openappengine.bpm.model.Event;
import com.openappengine.bpm.model.ProcessInstance;

/**
 * @author hrishi
 *
 */
public interface IProcessExecutor {
	
	public void startProcess(ProcessInstance processInstance);
	
	public void triggerEvent(ProcessInstance processInstance,Event event);

}
