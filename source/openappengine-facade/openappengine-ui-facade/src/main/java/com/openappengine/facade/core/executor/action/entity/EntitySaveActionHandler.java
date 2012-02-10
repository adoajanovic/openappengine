/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.DefaultActionMessageConstants;
import com.openappengine.facade.core.executor.annotations.Action;
import com.openappengine.facade.entity.EntityValue;

/**
 * The "entity-save" tag persists the specified PojoEntityValue object by creating a
 * new instance of the entity in the datasource. An error will result if an instance of the entity exists in
 * the datasource with the same primary key.
 * 
 * @author hrishi
 * since Jan 21, 2012
 */
@Action(actionName="entity-save")
public class EntitySaveActionHandler extends AbstractEntityActionHandler {
	
	public EntitySaveActionHandler() {
	}

	public Object execute(ActionContext actionContext) {
		
		String valueField = (String) getActionRequest().getActionParameter("valueField");
		
		if(StringUtils.isEmpty(valueField)) {
			logger.error("PojoEntityValue (value-field) set as null. Cannot perform Save");
			return null;
		}
		
		EntityValue pojoEntityValue = (EntityValue) actionContext.getELContext().getVariable(valueField);
		if(pojoEntityValue == null || pojoEntityValue.getInstance()==null) {
			logger.error("PojoEntityValue (value-field) set as null.");
			
			actionContext.getMessageContext().clearAllErrorMessages();
			actionContext.getMessageContext().addErrorMessage(DefaultActionMessageConstants.ENTITY_SAVE_ERROR);
			
			return null;
		}
		
		boolean updateIfExists = (Boolean) getActionRequest().getActionParameter("updateIfExists");
		if(updateIfExists) {
			logger.debug("Attribute 'updateIfExists' set as true, will update the value if it exists in the datastore.");
			getEntityFacade().saveOrUpdateEntityValue(pojoEntityValue);	
		} else {
			logger.debug("Attribute 'updateIfExists' set as false, if the entity value exists in the datastore, an exception is thrown.");
			getEntityFacade().saveEntityValue(pojoEntityValue);
		}
		

		// Replace the PojoEntityValue value-field in the ELContext with the updated PojoEntityValue.
		actionContext.getELContext().registerELContextVariable(valueField, pojoEntityValue);
		
		String successMessage = (String) getActionRequest().getActionParameter("successMessage");
		if(StringUtils.isNotBlank(successMessage)) {
			actionContext.getMessageContext().clearAllSuccessMessages();
			actionContext.getMessageContext().addSuccessMessage(successMessage);
		} else {
			actionContext.getMessageContext().addSuccessMessage(DefaultActionMessageConstants.ENTITY_SAVE_SUCCESS);
		}
				
		return pojoEntityValue;
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
