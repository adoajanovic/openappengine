/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

/**
 * @author hrishi
 * since Jan 2, 2012
 */
public interface ActionProcessor {

	/**
	 * Process the Actions.
	 * @return
	 */
	Object performProcessing(ActionContext actionContext);
	
}
