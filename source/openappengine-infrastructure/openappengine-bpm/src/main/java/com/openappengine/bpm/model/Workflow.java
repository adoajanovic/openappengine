/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hrishi
 *
 */
public class Workflow implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Map<String, ProcessModel> processModelMap;
	
	private String initProcess;

	public Workflow() {
		setProcessModelMap(new HashMap<String, ProcessModel>());
	}
	
	public ProcessModel getProcess(String processName) {
		return getProcessModelMap().get(processName);
	}
	
	public boolean addProcess(ProcessModel model) {
		if(model == null) {
			return false;
		}
		
		getProcessModelMap().put(model.getProcessName(), model);
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, ProcessModel> getProcessModelMap() {
		return processModelMap;
	}

	public void setProcessModelMap(Map<String, ProcessModel> processModelMap) {
		if(processModelMap == null) {
			return;
		}
		boolean initProcessDefined = false;
		Set<String> processes = processModelMap.keySet();
		for (String process : processes) {
			ProcessModel processModel = processModelMap.get(process);
			if(processModel.getProcessName().equals(initProcess)) {
				initProcessDefined = true;
				break;
			}
		}
		if(!initProcessDefined) {
			throw new WorkflowDefinitionException("No Init Process Defined for the Workflow");
		}
		this.processModelMap = processModelMap;
	}

}
