/**
 * 
 */
package com.openappengine.facade.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.executor.annotations.Action;

/**
 * @author hrishi
 * since Jan 1, 2012
 */
@Action(actionName="composite")
public class CompositeActionListHandler implements ActionHandler {
	
	private List<Executable> actions = new ArrayList<Executable>();
	
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
	public void setActionContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionResponseXml execute(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}

}
