package com.openappengine.gui.engine.core.component.executable;


public class EntitySaveActionComponent extends AbstractEntityActionTag {

	private static final long serialVersionUID = 1L;
	
	private boolean updateIfExists = true;
	
	@Override
	public String getComponentName() {
		return "entity-save";
	}

	public boolean isUpdateIfExists() {
		return updateIfExists;
	}

	public void setUpdateIfExists(boolean updateIfExists) {
		this.updateIfExists = updateIfExists;
	}

}
