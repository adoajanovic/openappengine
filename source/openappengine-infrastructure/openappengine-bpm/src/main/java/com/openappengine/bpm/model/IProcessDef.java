/**
 * 
 */
package com.openappengine.bpm.model;

/**
 * @author hrishi
 *
 */
public interface IProcessDef {
	
	public ProcessContext executeProcess(ProcessContext processContext);

}
