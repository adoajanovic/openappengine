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
public class CompositeActionListHandler implements ActionHandler {
	
	private List<Executable> actions = new ArrayList<Executable>();

	@Override
	public Object execute() {
		if(actions != null && !actions.isEmpty()) {
			for (Executable action : actions) {
				action.execute();
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
	public String getName() {
		return "composite";
	}
}
