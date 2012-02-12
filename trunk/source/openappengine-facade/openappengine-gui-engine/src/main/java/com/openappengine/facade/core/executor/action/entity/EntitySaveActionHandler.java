/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.action.xml.EntityActionRequestXml;
import com.openappengine.facade.core.executor.annotations.Action;

/**
 * The "entity-save" tag persists the specified PojoEntityValue object by creating a
 * new instance of the entity in the datasource. An error will result if an instance of the entity exists in
 * the datasource with the same primary key.
 * 
 * @author hrishi
 * since Jan 21, 2012
 */
@Action(actionName="entity-save")
public class EntitySaveActionHandler extends AbstractEntityActionHandler {

	@Override
	public ActionResponseXml execute(EntityActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
