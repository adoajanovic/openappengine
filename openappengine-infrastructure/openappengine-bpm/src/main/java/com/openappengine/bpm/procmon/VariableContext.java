/**
 * 
 */
package com.openappengine.bpm.procmon;

import java.io.Serializable;
import java.util.Map;

import javolution.util.FastMap;

/**
 * @author hrishi
 *
 */
public class VariableContext implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Variable Map.
	 */
	protected Map<String,Object> variableMap;
	
	/**
	 *  Default Constructor.
	 */
	public VariableContext() {
		this.variableMap = FastMap.newInstance();
	}

}
