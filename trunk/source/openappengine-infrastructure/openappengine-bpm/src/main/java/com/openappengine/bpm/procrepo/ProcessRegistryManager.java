/**
 * 
 */
package com.openappengine.bpm.procrepo;

import java.io.File;
import java.io.FileInputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.bpm.graph.ProcessDefinition;
import com.openappengine.bpm.procreader.IProcessDefReader;
import com.openappengine.bpm.procreader.ProcessDefReader;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class ProcessRegistryManager implements IProcessRegistryManager {
	
	//Set from Spring Context.
	/**
	 * {@link ProcessDefReader} to read the process registry.
	 */
	private IProcessDefReader processDefReader;
	
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
	public void setProcessDefReader(IProcessDefReader processDefReader) {
		this.processDefReader = processDefReader;
	}

}
