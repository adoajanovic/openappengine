/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.DefaultActionMessageConstants;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
public class EntityDeleteActionHandler extends AbstractEntityActionHandler {

	@Override
	public String getName() {
		return "entity-delete";
	}

	@Override
	public Object execute(ActionContext actionContext) {
		String valueField = (String) getActionRequest().getActionRequest("valueField");
		
		if(StringUtils.isEmpty(valueField)) {
			logger.error("EntityValue (value-field) set as null. Cannot perform Delete");
			return null;
		}
		
		EntityValue entityValue = (EntityValue) actionContext.getELContext().getVariable(valueField);
		if(entityValue == null || entityValue.getInstance()==null) {
			logger.error("EntityValue (value-field) set as null.");
			
			actionContext.getMessageContext().clearAllErrorMessages();
			actionContext.getMessageContext().addErrorMessage("entity.delete.error");
			
			return entityValue;
		}
		
		boolean result = getEntityFacade().deleteEntityValue(entityValue);
		if(result) {
			actionContext.getELContext().removeELContextVariable(valueField);
			
			String successMessage = (String) getActionRequest().getActionRequest("successMessage");
			if(StringUtils.isNotBlank(successMessage)) {
				actionContext.getMessageContext().addSuccessMessage(successMessage);
			} else {
				actionContext.getMessageContext().addSuccessMessage(DefaultActionMessageConstants.ENTITY_DELETE_SUCCESS);
			}
		}
		
		return entityValue;
	}

}
