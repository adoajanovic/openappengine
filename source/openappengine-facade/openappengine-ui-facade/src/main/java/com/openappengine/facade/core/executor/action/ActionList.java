/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishi
 * since Jan 1, 2012
 */
public class ActionList extends Action {
	
	private List<Executable> actions = new ArrayList<Executable>();

	@Override
	public Object execute(GuiApplicationContext context) {
		if(actions != null && actions.isEmpty()) {
			for (Executable action : actions) {
				action.execute(context);
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
}
