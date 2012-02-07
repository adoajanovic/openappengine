/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.DefaultActionMessageConstants;
import com.openappengine.facade.core.executor.annotations.ActionParams;
import com.openappengine.facade.core.executor.annotations.Mode;
import com.openappengine.facade.entity.PojoEntityValue;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
@ActionParams(actionName="entity-delete",mode=Mode.ALL)
public class EntityDeleteActionHandler extends AbstractEntityActionHandler {

	@Override
	public Object execute(ActionContext actionContext) {
		String valueField = (String) getActionRequest().getActionParameter("valueField");
		
		if(StringUtils.isEmpty(valueField)) {
			logger.error("PojoEntityValue (value-field) set as null. Cannot perform Delete");
			return null;
		}
		
		PojoEntityValue pojoEntityValue = (PojoEntityValue) actionContext.getELContext().getVariable(valueField);
		if(pojoEntityValue == null || pojoEntityValue.getInstance()==null) {
			logger.error("PojoEntityValue (value-field) set as null.");
			
			actionContext.getMessageContext().clearAllErrorMessages();
			actionContext.getMessageContext().addErrorMessage("entity.delete.error");
			
			return pojoEntityValue;
		}
		
		boolean result = getEntityFacade().deleteEntityValue(pojoEntityValue);
		if(result) {
			actionContext.getELContext().removeELContextVariable(valueField);
			
			String successMessage = (String) getActionRequest().getActionParameter("successMessage");
			if(StringUtils.isNotBlank(successMessage)) {
				actionContext.getMessageContext().addSuccessMessage(successMessage);
			} else {
				actionContext.getMessageContext().addSuccessMessage(DefaultActionMessageConstants.ENTITY_DELETE_SUCCESS);
			}
		}
		
		return pojoEntityValue;
	}

}
