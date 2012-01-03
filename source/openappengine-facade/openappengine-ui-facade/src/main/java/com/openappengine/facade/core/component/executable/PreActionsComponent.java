/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.executor.action.CompositeActionListHandler;
import com.openappengine.facade.core.executor.action.Executable;
import com.openappengine.facade.core.executor.action.request.DefaultActionRequest;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class PreActionsComponent extends AbstractExecutableComponent {

	private static final long serialVersionUID = 1L;
	
	private List<Executable> executables;

	@Override
	public String getComponentName() {
		return "pre-actions";
	}

	public List<Executable> getExecutables() {
		return executables;
	}

	public void setExecutables(List<Executable> executables) {
		this.executables = executables;
	}

	
	//TODO - needs to be diverged away from the Component Tree API. Command Dispatcher Pattern.
	@Override
	public Executable getExecutable() {
		CompositeActionListHandler actionList = new CompositeActionListHandler();
		if(getChildComponents() != null) {
			for (GuiComponent component : getChildComponents()) {
				Executable exec = ((AbstractExecutableComponent)component).getExecutable();
				actionList.addAction(exec);
			}
		}
		return actionList;
	}

	@Override
	public ActionRequest getActionRequest() {
		List<ActionRequest> actionRequests = new ArrayList<ActionRequest>();
		if(getChildComponents() != null) {
			for (GuiComponent component : getChildComponents()) {
				AbstractExecutableComponent executableComponent = ((AbstractExecutableComponent) component);
				ActionRequest actionRequest = executableComponent.getActionRequest();
				actionRequests.add(actionRequest);
			}
		}
		
		ActionRequest request = new DefaultActionRequest("pre-actions");
		request.addActionParameter("actionRequests", actionRequests);
		return request;
	}

}
