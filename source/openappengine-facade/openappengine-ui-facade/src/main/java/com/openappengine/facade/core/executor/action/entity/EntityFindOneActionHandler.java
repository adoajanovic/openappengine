/**
 * 
 */
package com.openappengine.facade.core.executor.action.entity;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.action.xml.EntityActionRequestXml;
import com.openappengine.facade.core.executor.annotations.Action;

/**
 * 	
 *	Does a "find-by" on the primary key. 
 *  If no value is found does nothing to the value-field. If a value is
 *  found, sets the value in the "value-field" attribute in the context.
 * 
 * @author hrishi
 *
 */
@Action(actionName="entity-find-one")
public class EntityFindOneActionHandler extends AbstractEntityActionHandler {
	
	@Override
	public ActionResponseXml execute(EntityActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}

}
