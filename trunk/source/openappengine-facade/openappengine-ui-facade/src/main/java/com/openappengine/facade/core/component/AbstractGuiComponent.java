/**
 * 
 */
package com.openappengine.facade.core.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractGuiComponent implements GuiComponent {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());

	private final List<GuiComponent> childComponents = new ArrayList<GuiComponent>();

	public List<GuiComponent> getChildComponents() {
		return childComponents;
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
