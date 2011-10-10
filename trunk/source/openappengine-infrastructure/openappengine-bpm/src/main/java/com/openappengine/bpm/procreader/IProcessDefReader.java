/**
 * 
 */
package com.openappengine.bpm.procreader;

import org.w3c.dom.Element;

import com.openappengine.bpm.procmod.ProcessDefinition;

/**
 * @author hrishi
 *
 */
public interface IProcessDefReader {
	
	/**
	 * Parse XML Element to extract the ProcessDefinition  
	 * @param element
	 * @return {@link ProcessDefinition}
	 * @throws ProcessDefinitionException 
	 */
	public ProcessDefinition readProcessDefinition(Element element) throws ProcessDefinitionException;

}
