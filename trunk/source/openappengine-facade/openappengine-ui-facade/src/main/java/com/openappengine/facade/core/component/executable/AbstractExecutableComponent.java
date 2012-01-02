/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.executor.action.Executable;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractExecutableComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentType() {
		return "executable";
	}
	
	/**
	 * Add an executable child Component to this component.
	 * @param component
	 * @return
	 */
	public boolean addChildComponent(GuiComponent component) {
		if(component == null) {
			return false;
		}
		if(component instanceof AbstractExecutableComponent) {
			return getChildComponents().add(component);
		} else {
			logger.error("Only an executable component can be added to the executable component node.");
			return false;
		}
	}
	
	public abstract Executable getExecutable();
	
}
