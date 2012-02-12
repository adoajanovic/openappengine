/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.entity;

import org.apache.log4j.Logger;

import com.openappengine.entity.EntityFacade;
import com.openappengine.entity.context.EntityFacadeContext;
import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.EntityActionRequestXml;
import com.openappengine.gui.engine.core.executor.action.ActionContext;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;

/**
 * @author hrishi
 *
 */
public abstract class AbstractEntityActionHandler implements ActionHandler<EntityActionRequestXml> {
	
	protected Logger logger = Logger.getLogger("EntityActionHandler");
	
	protected ActionContext actionContext;
	
	protected EntityFacade entityFacade;

	@Override
	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
	}

	protected EntityFacade getEntityFacade() {
		if(entityFacade == null) {
			entityFacade = EntityFacadeContext.getEntityFacade();
		}
		
		return entityFacade;
	}

	@Override
	public boolean supportsActionRequestXml(ActionRequestXml actionRequestXml) {
		if(actionRequestXml instanceof EntityActionRequestXml) {
			return true;
		}
		return false;
	}
	
}
