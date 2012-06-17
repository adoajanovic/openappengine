/**
 * 
 */
package com.openappengine.bpm.procrepo;

import com.openappengine.bpm.graph.ProcessDefinition;

/**
 * @author hrishi
 *
 */
public interface IProcessRegistryManager {
	
	/**
	 * Load the {@link ProcessRegistry} from the given definition files.
	 * @param definitionFiles
	 * @throws ProcessRegistryException 
	 */
	public void loadProcessRegistry(String[] definitionFiles) throws ProcessRegistryException;
	
	/**
	 * Load the {@link ProcessRegistry} from the given definition file.
	 * @param definitionFile
	 * @throws ProcessRegistryException 
	 */
	public void loadProcessRegistry(String definitionFile) throws ProcessRegistryException;
	
	public ProcessDefinition getProcessInstanceByProcessId(String processId) throws ProcessRegistryException;

}
