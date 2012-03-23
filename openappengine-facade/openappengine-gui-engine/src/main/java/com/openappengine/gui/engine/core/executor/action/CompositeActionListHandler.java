/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.action.xml.ActionRequestXml;
import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.executor.annotations.Action;

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

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#setActionContext(com.openappengine.gui.engine.core.executor.action.ActionContext)
	 */
	@Override
	public void setActionContext(ActionContext actionContext) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#supportsActionRequestXml(com.openappengine.gui.engine.core.action.xml.ActionRequestXml)
	 */
	@Override
	public boolean supportsActionRequestXml(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.gui.engine.core.executor.action.ActionHandler#execute(com.openappengine.gui.engine.core.action.xml.ActionRequestXml)
	 */
	@Override
	public ActionResponseXml execute(ActionRequestXml actionRequestXml) {
		// TODO Auto-generated method stub
		return null;
	}

}
