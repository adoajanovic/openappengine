/**
 * 
 */
package com.openappengine.bpm.procreg;

import java.util.HashMap;
import java.util.Map;

import com.openappengine.bpm.procmod.ProcessInstance;
import com.openappengine.utility.UtilString;

/**
 * @author hrishi
 *
 */
public class ProcessRegistry {
	
	/**
	 *  Process Registry Cache that holds all the processes configured to run in the ProcessEngine
	 */
	private static Map<String, ProcessInstance> processRegistryCache = new HashMap<String, ProcessInstance>();
	
	
	/**
	 * Register new ProcessInstance with the ProcessRegistry.
	 * @param processInstance
	 * @return
	 */
	public static boolean registerProcessInstance(ProcessInstance processInstance) {
		if(processInstance == null) {
			return false;
		}
		
		if(UtilString.isEmptyOrBlank(processInstance.getId())) {
			return false;
		}
		
		processRegistryCache.put(processInstance.getId(), processInstance);
		return true;
	}
	
	/**
	 * Unregister ProcessInstance from the ProcessRegistry.
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
		
		ProcessInstance processInstance = processRegistryCache.get(id);
		processRegistryCache.remove(processInstance);
		return true;
	}
	
	/**
	 * Get ProcessInstance from the ProcessRegistry by its Id.
	 * @param id
	 * @return {@link ProcessInstance}
	 */
	public static ProcessInstance getProcessInstanceByProcessId(String id) {
		if(UtilString.isEmptyOrBlank(id)) {
			return null;
		}
		
		if(!processRegistryCache.containsKey(id)) {
			return null;
		}
		
		ProcessInstance processInstance = processRegistryCache.get(id);
		return processInstance;
	}

}
