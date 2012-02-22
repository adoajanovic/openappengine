/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.entity;

import org.apache.log4j.Logger;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.context.EntityEngineFacadeContext;
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
	
	protected EntityEngineFacade entityEngineFacade;

	@Override
	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
	}

	protected EntityEngineFacade getEntityFacade() {
		if(entityEngineFacade == null) {
			entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
		}
		
		return entityEngineFacade;
	}

	@Override
	public boolean supportsActionRequestXml(ActionRequestXml actionRequestXml) {
		if(actionRequestXml instanceof EntityActionRequestXml) {
			return true;
		}
		return false;
	}
	
}
