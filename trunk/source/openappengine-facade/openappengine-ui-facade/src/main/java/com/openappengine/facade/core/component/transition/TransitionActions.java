/**
 * 
 */
package com.openappengine.facade.core.component.transition;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.executor.action.Executable;

/**
 * @author hrishi
 * since Jan 23, 2012
 */
public class TransitionActions extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	private List<Executable> executables = new ArrayList<Executable>();

	@Override
	public String getComponentName() {
		return "actions";
	}

	public List<Executable> getExecutables() {
		return executables;
	}

	public void setExecutables(List<Executable> executables) {
		this.executables = executables;
	}
	
	public void addExecutable(Executable executable) {
		if(executable == null) {
			return;
		}
		
		this.executables.add(executable);
	}

	@Override
	public String getComponentType() {
		return "transition-actions-container";
	}

}
