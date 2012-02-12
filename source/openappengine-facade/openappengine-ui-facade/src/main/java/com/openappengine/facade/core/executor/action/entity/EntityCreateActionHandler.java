/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import org.springframework.util.Assert;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.action.xml.EntityActionRequestXml;
import com.openappengine.facade.core.action.xml.SimpleActionResponseXml;
import com.openappengine.facade.core.executor.annotations.Action;
import com.openappengine.facade.entity.response.EntityResponse;

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
