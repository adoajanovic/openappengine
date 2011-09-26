/**
 * 
 */
package com.openappengine.bpm.model;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class ProcessExecutor {
	
	private Class<?> runnerClass;
	
	private final Logger logger = Logger.getLogger(getClass());

	public ProcessExecutor(String executor) {
		Class<?> executorClass;
		try {
			executorClass = Class.forName(executor);
			if(IProcessDef.class.isAssignableFrom(executorClass)) {
				this.runnerClass = executorClass;
			} else {
				throw new ProcessConfigurationException("Class : [" + executorClass.getName() + "] should implement IProcessDef or any other subclasses.");
			}
		} catch (ClassNotFoundException e) {
			throw new ProcessConfigurationException("Class : [" + executor + "] could not be found.");
		}
	}

	private IProcessDef instantiateProcessDef() {
		IProcessDef processDef = null;
		try {
			processDef = (IProcessDef)runnerClass.newInstance();
		} catch (InstantiationException e) {
			//TODO
		} catch (IllegalAccessException e) {
			//TODO
		}
		return processDef;
	}

	public WorkflowContext execute(WorkflowContext ctx) {
		logger.info("Executing Process : [" + runnerClass.getName() + "]...");
		IProcessDef processDef = instantiateProcessDef();
		if(processDef != null) {
			WorkflowContext resultContext = processDef.executeProcess(ctx);
			return resultContext;
		} else {
			throw new ProcessConfigurationException("Class : [" + runnerClass.getName() + "] could not be instantiated.");
		}
	}

}
