/**
 * 
 */
package com.openappengine.bpm.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.openappengine.bpm.procmod.State;

/**
 * @author hrishi
 *
 */
public class Workflow implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private List<State> processModels;
	
	private Map<String, State> processModelMap;
	
	private String initProcess;
	
	private final Logger logger = Logger.getLogger(getClass());
	
	public Workflow() {
		processModels = new ArrayList<State>();
	}
	
	public State getProcess(String processName) {
		return getProcessModelMap().get(processName);
	}
	
	public boolean addProcess(State model) {
		if(model == null) {
			return false;
		}
		
		if(getProcessModelMap() == null) {
			setProcessModelMap(new HashMap<String, State>());
		}
		getProcessModelMap().put(model.getName(), model);
		
		processModels.add(model);
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, State> getProcessModelMap() {
		return processModelMap;
	}

	public void setProcessModelMap(Map<String, State> processModelMap) {
		if(processModelMap == null) {
			return;
		}
		
		this.processModelMap = processModelMap;
	}

	public String getInitProcess() {
		return initProcess;
	}

	public void setInitProcess(String initProcess) {
		this.initProcess = initProcess;
	}
	
}
