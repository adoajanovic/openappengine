package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.executor.annotations.Action;


/**
 * @author hrishi
 * since Feb 4, 2012
 */
@Action(actionName="entity-delete")
public class EntityDeleteActionComponent extends AbstractEntityActionTag {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentName() {
		return "entity-delete";
	}

}
