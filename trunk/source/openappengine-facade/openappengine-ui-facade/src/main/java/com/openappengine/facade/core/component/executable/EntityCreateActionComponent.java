/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.executor.annotations.Action;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
@Action(actionName="entity-create")
public class EntityCreateActionComponent extends AbstractEntityActionComponent {

	private static final long serialVersionUID = 1L;
	
	private String entityName;
	
	private String entityMode = "xml";

	@Override
	public String getComponentName() {
		return "entity-create";
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityMode() {
		return entityMode;
	}

	public void setEntityMode(String entityMode) {
		this.entityMode = entityMode;
	}

}
