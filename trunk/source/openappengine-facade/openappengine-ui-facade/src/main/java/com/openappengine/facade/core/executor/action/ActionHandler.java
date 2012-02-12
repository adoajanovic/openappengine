/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;

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
