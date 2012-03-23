/**
 * 
 */
package com.openappengine.bpm.executable;

import java.io.Serializable;

import com.openappengine.bpm.procmon.ContextInstance;
import com.openappengine.bpm.procmon.ProcessInstance;

/**
 * @author hrishi
 *
 */
public class ExecutionContext implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 *  The {@link ContextInstance} associated with the Running {@link ProcessInstance}.
	 *  This would be set from the ProcessEngine at Runtime.
	 */
	private ContextInstance contextInstance;

	/**
	 * @return the contextInstance
	 */
	public ContextInstance getContextInstance() {
		return contextInstance;
	}

	/**
	 * @param contextInstance the contextInstance to set
	 */
	public void setContextInstance(ContextInstance contextInstance) {
		this.contextInstance = contextInstance;
	}

}
