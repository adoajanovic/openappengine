/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.context.EntityFacadeContext;

/**
 * @author hrishi
 *
 */
public abstract class AbstractEntityActionHandler implements ActionHandler {
	
	protected Logger logger = Logger.getLogger("EntityActionHandler");
	
	private String entityName;

	/**
	 * @param entityName
	 */
	public AbstractEntityActionHandler() {
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	protected EntityFacade getEntityFacade() {
		EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
		
		return entityFacade;
	}
}
