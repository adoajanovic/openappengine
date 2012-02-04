package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.request.EntityActionRequest;

public class EntitySaveActionComponent extends AbstractEntityActionComponent {

	private static final long serialVersionUID = 1L;
	
	private boolean updateIfExists = true;
	
	private String successMessage;
	
	@Override
	public String getComponentName() {
		return "entity-save";
	}

	@Override
	public ActionRequest createActionRequest() {
		EntityActionRequest actionRequest = new EntityActionRequest("entity-save",this);
		return actionRequest;
	}

	public boolean isUpdateIfExists() {
		return updateIfExists;
	}

	public void setUpdateIfExists(boolean updateIfExists) {
		this.updateIfExists = updateIfExists;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
