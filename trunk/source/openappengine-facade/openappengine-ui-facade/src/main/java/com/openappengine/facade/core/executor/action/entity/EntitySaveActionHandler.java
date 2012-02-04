/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.entity.EntityValue;

/**
 * The "entity-save" tag persists the specified EntityValue object by creating a
 * new instance of the entity in the datasource. An error will result if an instance of the entity exists in
 * the datasource with the same primary key.
 * 
 * @author hrishi
 * since Jan 21, 2012
 */
public class EntitySaveActionHandler extends AbstractEntityActionHandler {
	
	private boolean updateIfExists = true;
	
	private String valueField;
	
	private EntityValue entityValue; 
	
	private String successMessage;
	
	public EntitySaveActionHandler() {
	}

	@Override
	public String getName() {
		return "entity-save";
	}

	@Override
	public Object execute(ActionContext actionContext) {
		if(StringUtils.isEmpty(valueField)) {
			logger.error("EntityValue (value-field) set as null. Cannot perform Save");
			return null;
		}
		
		entityValue = (EntityValue) actionContext.getELContext().getVariable(valueField);
		if(entityValue == null || entityValue.getInstance()==null) {
			logger.error("EntityValue (value-field) set as null.");
			
			actionContext.getMessageContext().clearAllErrorMessages();
			actionContext.getMessageContext().addErrorMessage("entity.update.error");
			
			return null;
		}
		
		if(updateIfExists) {
			logger.debug("Attribute 'updateIfExists' set as true, will update the value if it exists in the datastore.");
			getEntityFacade().saveOrUpdateEntityValue(entityValue);	
		} else {
			logger.debug("Attribute 'updateIfExists' set as false, if the entity value exists in the datastore, an exception is thrown.");
			getEntityFacade().saveEntityValue(entityValue);
		}
		

		// Replace the EntityValue value-field in the ELContext with the updated EntityValue.
		actionContext.getELContext().registerELContextVariable(valueField, entityValue);
		
		if(StringUtils.isNotBlank(successMessage)) {
			actionContext.getMessageContext().clearAllSuccessMessages();
			actionContext.getMessageContext().addSuccessMessage(successMessage);
		}
				
		return entityValue;
	}

	public EntityValue getEntityValue() {
		return entityValue;
	}

	public void setEntityValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}

	public boolean isUpdateIfExists() {
		return updateIfExists;
	}

	public void setUpdateIfExists(boolean updateIfExists) {
		this.updateIfExists = updateIfExists;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
