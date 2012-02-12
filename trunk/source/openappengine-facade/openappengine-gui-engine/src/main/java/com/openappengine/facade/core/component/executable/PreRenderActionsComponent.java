/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.ComponentTypes;
import com.openappengine.facade.core.executor.action.Executable;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class PreRenderActionsComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	private List<Executable> executables;

	@Override
	public String getComponentName() {
		return "pre-actions";
	}
	
	@Override
	public String getComponentType() {
		return ComponentTypes.PRE_RENDER_COMPONENT;
	}
	
	public List<Executable> getExecutables() {
		return executables;
	}
	
	public void setExecutables(List<Executable> executables) {
		this.executables = executables;
	}
}
