/**
 *  The Context of variables to be associated with the running {@link ProcessInstance}.
 */
package com.openappengine.bpm.procmon;

import java.util.Map;

import com.openappengine.utility.UtilString;


/**
 * @author hrishi
 *
 */
public class ContextInstance extends VariableContext {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create a new variable in the running {@link ProcessInstance}
	 * @param name
	 * @param value
	 */
	public void createVariable(String name,Object value) {
		if(UtilString.isEmptyOrBlank(name) || value == null) {
			return;
		}
		
		variableMap.put(name, value);
	}
	
	/**
	 * Create variables local to the running {@link ProcessInstance}
	 * @param variables
	 */
	public void createVariables(Map<String,Object> variables) {
		if(variables == null || variables.isEmpty()) {
			return;
		}
		variableMap.putAll(variables);
	}
	
	/**
	 * Delete the variable from the running {@link ProcessInstance}.
	 * @param name
	 */
	public void deleteVariable(String name) {
		if(UtilString.isEmptyOrBlank(name) || !variableMap.containsKey(name)) {
			return;
		}
		
		variableMap.remove(variableMap.get(name));
	}

}
