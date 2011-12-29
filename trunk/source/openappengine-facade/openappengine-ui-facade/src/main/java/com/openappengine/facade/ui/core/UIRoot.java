/**
 * 
 */
package com.openappengine.facade.ui.core;

import java.util.List;
import java.util.Map;

import com.openappengine.facade.ui.context.Variable;
import com.openappengine.facade.ui.fsm.Transition;
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
	 * Get Transitions defined on the root node.
	 * @return
	 */
	List<Transition> getScreenTransitions();
	
	/**
	 * @return
	 */
	PreAction getPreAction();
	
}
