/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class Workflow implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private List<ProcessModel> processModels;
	
	private Map<String, ProcessModel> processModelMap;
	
	private String initProcess;
	
	private final Logger logger = Logger.getLogger(getClass());
	
	//TODO
	private List<String> initProcesses;

	public Workflow() {
		processModels = new ArrayList<ProcessModel>();
	}
	
	public ProcessModel getProcess(String processName) {
		return getProcessModelMap().get(processName);
	}
	
	public boolean addProcess(ProcessModel model) {
		if(model == null) {
			return false;
		}
		
		if(getProcessModelMap() == null) {
			setProcessModelMap(new HashMap<String, ProcessModel>());
		}
		getProcessModelMap().put(model.getProcessName(), model);
		
		if(model.getSequenceNo() == 0) {
			int size;
			size = processModels.size();
			model.setSequenceNo(size);
		}
		processModels.add(model);
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
		
		this.processModelMap = processModelMap;
	}

	public String getInitProcess() {
		return initProcess;
	}

	public void setInitProcess(String initProcess) {
		this.initProcess = initProcess;
	}

	public List<String> getInitProcesses() {
		return initProcesses;
	}

	public void setInitProcesses(List<String> initProcesses) {
		this.initProcesses = initProcesses;
	}

}
