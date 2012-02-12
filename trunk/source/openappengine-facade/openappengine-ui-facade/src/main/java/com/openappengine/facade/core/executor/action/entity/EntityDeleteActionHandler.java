/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.action.xml.EntityActionRequestXml;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.annotations.Action;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
@Action(actionName="entity-delete")
public class EntityDeleteActionHandler extends AbstractEntityActionHandler {

	@Override
	public void setActionContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionResponseXml execute(EntityActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}

}
