/**
 * 
 */
package com.openappengine.bpm.proceng;

import java.util.Map;
import java.util.Set;

import javax.xml.stream.events.ProcessingInstruction;

import com.openappengine.bpm.procmon.ProcessInstance;

/**
 * @author hrishi
 *
 */
public interface ProcessExecutionService {
	
	/**
	 * Start the ProcessInstance by its unique ProcessId.
	 * @param processDefId
	 * @return {@link ProcessInstance} - Running ProcessInstance
	 */
	public ProcessInstance startProcessInstanceByProcessDefinitonId(String processDefId);
	
	/**
	 * Start the ProcessInstance by its unique ProcessId.
	 * @param processDefId
	 * @param variables
	 * @return {@link ProcessInstance} - Running ProcessInstance
	 */
	public ProcessInstance startProcessInstanceByProcessDefinitonId(String processDefId,Map<String,Object> variables);
	
	
	/**
	 * Signal an Event to the Running ProcessInstance.
	 * @param pid
	 * @return {@link ProcessInstance} - Running ProcessInstance
	 */
	public ProcessInstance signalProcessInstanceByProcessId(String pid,String event);
	

	/**
	 * Signal an Event to the Running ProcessInstance.
	 * @param pid
	 * @param event
	 * @param parameters
	 * @return {@link ProcessInstance} - Running ProcessInstance
	 */
	public ProcessInstance signalProcessInstanceByProcessId(String pid,String event,Map<String,Object> parameters);

	/**
	 * Set variable in the running {@link ProcessInstance}.
	 * @param processId
	 * @param name
	 * @param value
	 */
	public void setVariable(String processId, String name, Object value);
	
	/**
	 * Get the variable of the given name in the process running with the input processId.
	 * @param processId
	 * @param name
	 * @return Object - Variable from the running processId.
	 */
	public Object getVariable(String processId, String name);
	
	/**
	 * Get the variables of the given names in the process running with the input processId.
	 * @param processId
	 * @param names
	 * @return map of variables
	 */
	public Map<String,Object> getVariables(String processId, Set<String> names);
	
	/**
	 * Set variable map in the running {@link ProcessingInstruction}.
	 * @param processId
	 * @param variables
	 */
	public void setVariables(String processId,Map<String,Object> variables);
}
