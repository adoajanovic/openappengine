package com.openappengine.facade.core.executor.action;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.executor.action.dispatcher.ActionDispatcherFactory;
import com.openappengine.facade.core.executor.annotations.Action;

@Action(actionName="pre-actions")
public class PreActionHandler implements ActionHandler {

	private List<ActionRequest> actionRequests = new ArrayList<ActionRequest>();
	
	private ActionRequest actionRequest;

	public Object execute(ActionContext actionContext) {
		for(ActionRequest actionRequest : getActionRequests()) {
			ActionDispatcherFactory actionDispatcherFactory = new ActionDispatcherFactory();
			ActionDispatcher actionDispatcher = actionDispatcherFactory.createActionDispatcher(actionContext.getELContext(), actionContext.getExternalContext(), actionContext.getMessageContext());
			Object result = actionDispatcher.execute(actionRequest);
			return result;
		}
		return null;
	}

	public List<ActionRequest> getActionRequests() {
		return actionRequests;
	}

	public void setActionRequests(List<ActionRequest> actionRequests) {
		this.actionRequests = actionRequests;
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
