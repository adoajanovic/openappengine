/**
 * 
 */
package com.openappengine.bpm.procreg;

import java.util.HashMap;
import java.util.Map;

import com.openappengine.bpm.procmod.ProcessDefinition;
import com.openappengine.utility.UtilString;

/**
 * @author hrishi
 *
 */
public class ProcessRegistry {
	
	/**
	 *  Process Registry Cache that holds all the processes configured to run in the ProcessEngine
	 */
	private static Map<String, ProcessDefinition> processRegistryCache = new HashMap<String, ProcessDefinition>();
	
	
	/**
	 * Register new ProcessDefinition with the ProcessRegistry.
	 * @param processDefinition
	 * @return
	 */
	public static boolean registerProcessInstance(ProcessDefinition processDefinition) {
		if(processDefinition == null) {
			return false;
		}
		
		if(UtilString.isEmptyOrBlank(processDefinition.getId())) {
			return false;
		}
		
		processRegistryCache.put(processDefinition.getId(), processDefinition);
		return true;
	}
	
	/**
	 * Unregister ProcessDefinition from the ProcessRegistry.
	 * @param id
	 * @return
	 */
	public static boolean unregisterProcessInstance(String id) {
		if(UtilString.isEmptyOrBlank(id)) {
			return false;
		}
		
		if(!processRegistryCache.containsKey(id)) {
			return false;
		}
		
		ProcessDefinition processDefinition = processRegistryCache.get(id);
		processRegistryCache.remove(processDefinition);
		return true;
	}
	
	/**
	 * Get ProcessDefinition from the ProcessRegistry by its Id.
	 * @param id
	 * @return {@link ProcessDefinition}
	 */
	public static ProcessDefinition getProcessInstanceByProcessId(String id) {
		if(!isProcessInstanceRegistered(id)) {
			return null;
		}
		
		ProcessDefinition processDefinition = processRegistryCache.get(id);
		return processDefinition;
	}

	/**
	 * Is ProcessDefinition registered with the ProcessRegistry.
	 * @param id
	 * @return
	 */
	private static boolean isProcessInstanceRegistered(String id) {
		return !(UtilString.isEmptyOrBlank(id) ||!processRegistryCache.containsKey(id));
	}
	
	public static void updateProcessInstanceById(String id, ProcessDefinition instance) {
		
	}
	

}
