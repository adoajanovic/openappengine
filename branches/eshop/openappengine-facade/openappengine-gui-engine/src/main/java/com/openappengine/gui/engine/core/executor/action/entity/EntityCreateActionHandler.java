/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.entity;

import org.springframework.util.Assert;

import com.openappengine.entity.response.EntityResponse;
import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.action.xml.EntityActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.SimpleActionResponseXml;
import com.openappengine.gui.engine.core.executor.annotations.Action;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
@Action(actionName="entity-create")
public class EntityCreateActionHandler extends AbstractEntityActionHandler {

	@Override
	public ActionResponseXml execute(EntityActionRequestXml actionRequestXml) {
		String entityName = actionRequestXml.getEntityName();
		Assert.notNull(entityName, "EntityName null.");
		
		EntityResponse entityResponse = getEntityFacade().createEntityValue(entityName);
		
		//TODO - Convert to Xml.
		return new SimpleActionResponseXml(entityResponse.getEntityResponseDocument());
	}

}
