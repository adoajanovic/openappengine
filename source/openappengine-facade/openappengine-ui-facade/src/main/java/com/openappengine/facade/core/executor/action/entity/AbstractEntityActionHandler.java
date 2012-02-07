/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.entity.EntityFacade;
import com.openappengine.facade.entity.context.EntityFacadeContext;

/**
 * @author hrishi
 *
 */
public abstract class AbstractEntityActionHandler implements ActionHandler {
	
	protected Logger logger = Logger.getLogger("EntityActionHandler");
	
	private ActionRequest actionRequest;

	/**
	 * @param entityName
	 */
	public AbstractEntityActionHandler() {
	}

	public String getEntityName() {
		String entityName = (String) actionRequest.getActionParameter("entityName");
		return entityName;
	}

	protected EntityFacade getEntityFacade() {
		EntityFacade entityFacade = EntityFacadeContext.getEntityFacade();
		
		return entityFacade;
	}

	public ActionRequest getActionRequest() {
		return actionRequest;
	}

	public void setActionRequest(ActionRequest actionRequest) {
		this.actionRequest = actionRequest;
	}
}
