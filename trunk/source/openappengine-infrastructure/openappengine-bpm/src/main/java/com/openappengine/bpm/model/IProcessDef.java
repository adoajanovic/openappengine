/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishi
 *
 */
public interface IProcessDef {
	
	public WorkflowContext executeProcess(WorkflowContext processContext);

}
