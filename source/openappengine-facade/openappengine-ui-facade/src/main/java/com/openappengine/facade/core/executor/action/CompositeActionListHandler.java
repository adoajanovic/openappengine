/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.annotations.ActionParams;
import com.openappengine.facade.core.executor.annotations.Mode;

/**
 * @author hrishi
 * since Jan 1, 2012
 */
@ActionParams(actionName="composite",mode=Mode.ALL)
public class CompositeActionListHandler implements ActionHandler {
	
	private List<Executable> actions = new ArrayList<Executable>();
	
	private ActionRequest actionRequest;

	@Override
	public Object execute(ActionContext actionContext) {
		if(actions != null && !actions.isEmpty()) {
			for (Executable action : actions) {
				action.execute(actionContext);
			}
		}
		return null;
	}

	public List<Executable> getActions() {
		return actions;
	}

	public void setActions(List<Executable> actions) {
		this.actions = actions;
	}

	public void addAction(Executable action) {
		if(action == null) {
			return;
		}
		
		actions.add(action);
	}

	@Override
	public void setActionRequest(ActionRequest actionRequest) {
		this.actionRequest = actionRequest;
	}
}
