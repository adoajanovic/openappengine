package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.request.EntityActionRequest;

/**
 * @author hrishi
 * since Feb 4, 2012
 */
public class EntityDeleteActionComponent extends AbstractEntityActionComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentName() {
		return "entity-delete";
	}

	@Override
	public ActionRequest createActionRequest() {
		return new EntityActionRequest(getComponentName(), this);
	}

}
