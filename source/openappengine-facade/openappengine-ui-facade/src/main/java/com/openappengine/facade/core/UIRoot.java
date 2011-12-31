/**
 * 
 */
package com.openappengine.facade.core;

import java.util.Map;

import com.openappengine.facade.core.variable.Variable;
import com.openappengine.facade.ui.params.Parameters;
import com.openappengine.facade.ui.preaction.PreAction;



/**
 * @author hrishi
 * since Dec 29, 2011
 */
public interface UIRoot {

	/**
	 * Get the Screen Variables keyed by their name.
	 * @return
	 */
	Map<String,Variable> getScreenVariables();
	
	/**
	 * Preactions to be executed conditionally/unconditionally.
	 * @return
	 */
	PreAction getPreAction();
	
	/**
	 * Get Input Parameters for the UI Root.
	 * @return
	 */
	Parameters getInputParameters();
	
}
