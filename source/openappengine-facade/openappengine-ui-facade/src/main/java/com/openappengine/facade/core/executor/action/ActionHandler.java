/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.ActionRequest;

/**
 * Abstract SuperClass for the ActionHandler's which know how to execute particular 
 * actions wrapped as classed (Command Pattern). 
 * 
 * @author hrishi
 */
public interface ActionHandler extends Executable {

	void setActionRequest(ActionRequest actionRequest);
}
