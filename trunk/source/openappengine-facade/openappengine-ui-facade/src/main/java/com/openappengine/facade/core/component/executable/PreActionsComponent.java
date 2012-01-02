/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.List;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.executor.action.ActionList;
import com.openappengine.facade.core.executor.action.Executable;

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

	@Override
	public Executable getExecutable() {
		ActionList actionList = new ActionList();
		if(getChildComponents() != null) {
			for (GuiComponent component : getChildComponents()) {
				Executable exec = ((AbstractExecutableComponent)component).getExecutable();
				actionList.addAction(exec);
			}
		}
		return actionList;
	}

}
