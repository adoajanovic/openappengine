/**
 * 
 */
package com.openappengine.bpm.workflow;

import java.util.HashMap;
import java.util.Map;


/**
 * @author hrishi
 *
 */
public class WorkflowDefinitionRegistry {
	
	private static final Map<String, Workflow> WORKFLOW_DEFINITION_REGISTRY_CACHE;
	
	static {
		WORKFLOW_DEFINITION_REGISTRY_CACHE = new HashMap<String, Workflow>();
	}
	
	public static void addWorkflow(Workflow workflow) {
		if(workflow == null) {
			return;
		}
		
		WORKFLOW_DEFINITION_REGISTRY_CACHE.put(workflow.getName(), workflow);
	}
	
	public static Workflow getWorkflow(String processName) {
		return WORKFLOW_DEFINITION_REGISTRY_CACHE.get(processName);
	}

}
