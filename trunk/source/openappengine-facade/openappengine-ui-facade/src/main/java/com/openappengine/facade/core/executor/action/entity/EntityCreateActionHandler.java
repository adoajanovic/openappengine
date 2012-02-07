/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.annotations.ActionParams;
import com.openappengine.facade.core.executor.annotations.Mode;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
@ActionParams(actionName="entity-create",mode=Mode.ALL)
public class EntityCreateActionHandler extends AbstractEntityActionHandler {

	@Override
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

}
