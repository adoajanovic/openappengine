/**
 * 
 */
package com.openappengine.bpm.procreader;

import com.openappengine.bpm.graph.ProcessDefinition;

/**
 * @author hrishi
 *
 */
public interface IProcessDefReader {
	
	/**
	 * Parse XML Element to extract the ProcessDefinition  
	 * @return {@link ProcessDefinition}
	 * @throws ProcessDefinitionException 
	 */
	public ProcessDefinition readProcessDefinition() throws ProcessDefinitionException;

}
