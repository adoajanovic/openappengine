/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.annotations.ActionParams;
import com.openappengine.facade.core.executor.annotations.EntityMode;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
@ActionParams(actionName="",entityMode=EntityMode.XML)
public class EntityCreateActionHandler extends AbstractEntityActionHandler {

	//TODO - Remove this..!
	@Override
	public String getName() {
		return "entity-create";
	}

	@Override
	public Object execute(ActionContext actionContext) {
		String entityName = (String) getActionRequest().getActionParameter("entityName");
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName cannot be empty.");
		}
		
		String entityMode = getActionRequest().getActionParameter("entityMode",String.class);
		if(entityMode == null) {
			entityMode = "xml";
		}
		
		boolean xmlMode = false;
		if(StringUtils.equals(entityMode, "xml")) {
			xmlMode = true;
		}
		
		EntityValue entityValue = getEntityFacade().createEntityValue(entityName, xmlMode);
		
		return entityValue;
	}

}
