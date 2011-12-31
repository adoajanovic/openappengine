/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.List;

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

	/**
	 * @return the executables
	 */
	public List<Executable> getExecutables() {
		return executables;
	}

	/**
	 * @param executables the executables to set
	 */
	public void setExecutables(List<Executable> executables) {
		this.executables = executables;
	}

}
