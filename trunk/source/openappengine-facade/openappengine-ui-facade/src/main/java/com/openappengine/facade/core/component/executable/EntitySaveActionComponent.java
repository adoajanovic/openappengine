package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.request.DefaultActionRequest;
import com.openappengine.facade.entity.EntityValue;

public class EntitySaveActionComponent extends AbstractExecutableComponent {

	private static final long serialVersionUID = 1L;
	
	private boolean updateIfExists = true;
	
	private EntityValue entityValue; 

	@Override
	public String getComponentName() {
		return "entity-save";
	}

	@Override
	public ActionRequest getActionRequest() {
		ActionRequest actionRequest = new DefaultActionRequest("entity-save");
		actionRequest.addActionParameter("updateIfExists", updateIfExists);
		actionRequest.addActionParameter("entityValue", entityValue);
		return actionRequest;
	}

	public boolean isUpdateIfExists() {
		return updateIfExists;
	}

	public void setUpdateIfExists(boolean updateIfExists) {
		this.updateIfExists = updateIfExists;
	}

	public EntityValue getEntityValue() {
		return entityValue;
	}

	public void setEntityValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}

}
