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
 */
public interface ActionHandler extends Executable {

	void setActionContext(ActionContext actionContext);
	
	ActionResponseXml execute(ActionRequestXml actionRequestXml);
}
