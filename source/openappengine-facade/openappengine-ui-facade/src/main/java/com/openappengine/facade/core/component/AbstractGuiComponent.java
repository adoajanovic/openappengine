/**
 * 
 */
package com.openappengine.facade.core.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractGuiComponent implements GuiComponent {

	private static final long serialVersionUID = 1L;

	private List<GuiComponent> childComponents = new ArrayList<GuiComponent>();

	public List<GuiComponent> getChildComponents() {
		return childComponents;
	}

	protected void setChildComponents(List<GuiComponent> childComponents) {
		this.childComponents = childComponents;
	}

	/**
	 * Add Child Component to this component.
	 * @param screenComponent
	 * @return
	 */
	public boolean addChildComponent(GuiComponent screenComponent) {
		if(screenComponent == null) {
			return false;
		}
		return childComponents.add(screenComponent);
	}

}
