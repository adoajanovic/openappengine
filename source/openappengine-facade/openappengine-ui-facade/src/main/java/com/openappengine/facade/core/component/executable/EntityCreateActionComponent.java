/**
 * 
 */
package com.openappengine.facade.core.component.executable;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class EntityCreateActionComponent extends AbstractEntityActionComponent {

	private static final long serialVersionUID = 1L;
	
	private String entityName;

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

}
