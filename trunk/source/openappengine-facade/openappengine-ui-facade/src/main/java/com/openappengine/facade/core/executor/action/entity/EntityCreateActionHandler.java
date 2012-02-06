/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.PojoEntityValue;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class EntityCreateActionHandler extends AbstractEntityActionHandler {

	@Override
	public String getName() {
		return "entity-create";
	}

	@Override
	public Object execute(ActionContext actionContext) {
		String entityName = (String) getActionRequest().getActionRequest("entityName");
		if(StringUtils.isEmpty(entityName)) {
			throw new IllegalArgumentException("EntityName cannot be empty.");
		}
		
		EntityValue pojoEntityValue = getEntityFacade().createEntityValue(entityName);
		return pojoEntityValue;
	}

}
