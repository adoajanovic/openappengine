/**
 * 
 */
package com.openappengine.gui.engine.core.component.executable;

import java.util.List;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;
import com.openappengine.gui.engine.core.component.ComponentTypes;
import com.openappengine.gui.engine.core.executor.action.Executable;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class PreRenderActions extends AbstractGuiComponent {

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
