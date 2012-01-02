/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.List;

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
		if(executables != null && !executables.isEmpty()) {
			for (Executable exec : executables) {
				actionList.addAction(exec);
			}
		}
		return actionList;
	}

}
