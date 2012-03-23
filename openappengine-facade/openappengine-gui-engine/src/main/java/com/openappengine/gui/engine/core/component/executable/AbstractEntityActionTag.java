/**
 * 
 */
package com.openappengine.gui.engine.core.component.executable;

import com.openappengine.gui.engine.core.annotations.ActionParam;



/**
 * @author hrishi
 * since Jan 29, 2012
 */
public abstract class AbstractEntityActionTag extends AbstractExecutableComponent {
	
	private static final long serialVersionUID = 1L;
	
	@ActionParam(name="success-message")
	private String successMessage;
	
	@ActionParam(name="entity-name")
	private String entityName;
	
	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public String getComponentName() {
		return null;
	}
}
