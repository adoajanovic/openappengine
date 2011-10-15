/**
 * 
 */
package com.openappengine.bpm.procrepo;

import java.io.File;

import com.openappengine.bpm.procreader.ProcessDefReader;

/**
 * @author hrishi
 *
 */
public class ProcessRegistryManager implements IProcessRegistryManager {
	
	//Set from Spring Context.
	/**
	 * {@link ProcessDefReader} to read the process registry.
	 */
	private ProcessDefReader processDefReader;
	
	public ProcessRegistryManager() {
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.procrepo.IProcessRegistryManager#loadProcessRegistry(java.io.File[])
	 */
	public void loadProcessRegistry(File[] definitionFiles) throws ProcessRegistryException {
		if(definitionFiles != null && definitionFiles.length != 0) {
			for (File file : definitionFiles) {
				loadProcessRegistry(file);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.openappengine.bpm.procrepo.IProcessRegistryManager#loadProcessRegistry(java.io.File)
	 */
	public void loadProcessRegistry(File definitionFile) throws ProcessRegistryException {
		if(definitionFile!=null && definitionFile.exists()) {
			try {
				//TODO
			} catch (Exception e) {
				throw new ProcessRegistryException(e);
			}
			
		}
	}

	/**
	 * @param processDefReader the processDefReader to set
	 */
	public void setProcessDefReader(ProcessDefReader processDefReader) {
		this.processDefReader = processDefReader;
	}

}
