/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;

/**
 * Abstract SuperClass for the ActionHandler's which know how to execute particular 
 * actions wrapped as classed (Command Pattern). 
 * 
 * @author hrishi
 * @param <T>
 */
public interface ActionHandler<T extends ActionRequestXml> extends Executable {

	void setActionContext(ActionContext actionContext);
	
	boolean supportsActionRequestXml(ActionRequestXml actionRequestXml);
	
	ActionResponseXml execute(T actionRequestXml);
}
