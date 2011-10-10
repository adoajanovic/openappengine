/**
 * 
 */
package com.openappengine.bpm.procreg;

import java.io.File;

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
	public void loadProcessRegistry(File[] definitionFiles) throws ProcessRegistryException;
	
	/**
	 * Load the {@link ProcessRegistry} from the given definition file.
	 * @param definitionFile
	 * @throws ProcessRegistryException 
	 */
	public void loadProcessRegistry(File definitionFile) throws ProcessRegistryException;

}
