/**
 * 
 */
package com.openappengine.bpm.procrepo;

import java.io.File;
import java.io.FileInputStream;

import com.openappengine.bpm.graph.ProcessDefinition;
import com.openappengine.bpm.procreader.ProcessDefReader;

/**
 * @author hrishi
 *
 */
public class ProcessRegistryManager implements IProcessRegistryManager {
	
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
				ProcessDefReader defReader = new ProcessDefReader(new FileInputStream(definitionFile));
				ProcessDefinition processDefinition = defReader.readProcessDefinition();
				ProcessRegistry.registerProcessInstance(processDefinition);
			} catch (Exception e) {
				throw new ProcessRegistryException(e);
			}
			
		}
	}

}
