/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.annotations.Action;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
@Action(actionName="entity-create")
public class EntityCreateActionHandler extends AbstractEntityActionHandler {

	public Object execute(ActionContext actionContext) {
		String entityName = (String) getActionRequest().getActionParameter("entityName");
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName cannot be empty.");
		}
		
		String mode = getActionRequest().getMode();
		if(StringUtils.isEmpty(mode)) {
			mode = "xml";
		}
		
		boolean xmlMode = false;
		if(StringUtils.equals(mode, "xml")) {
			xmlMode = true;
		}
		
		EntityValue entityValue = getEntityFacade().createEntityValue(entityName, xmlMode);
		
		return entityValue;
	}

	@Override
	public void setActionContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionResponseXml execute(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}

}
