/**
 * 
 */
package com.openappengine.facade.core.component.transition;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;

/**
 * @author hrishi
 * since Jan 23, 2012
 */
public class TransitionActions extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	private List<AbstractExecutableComponent> executables = new ArrayList<AbstractExecutableComponent>();

	@Override
	public String getComponentName() {
		return "actions";
	}

	/**
	 * @return the executables
	 */
	public List<AbstractExecutableComponent> getExecutables() {
		return executables;
	}


	/**
	 * @param executables the executables to set
	 */
	public void setExecutables(List<AbstractExecutableComponent> executables) {
		this.executables = executables;
	}

	public void addExecutable(AbstractExecutableComponent executableComponent) {
		if(executableComponent == null) {
			return;
		}
		
		this.executables.add(executableComponent);
	}

	@Override
	public String getComponentType() {
		return "transition-actions-container";
	}

}
