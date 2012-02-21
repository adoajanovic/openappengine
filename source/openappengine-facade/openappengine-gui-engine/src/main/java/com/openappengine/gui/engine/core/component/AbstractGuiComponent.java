/**
 * 
 */
package com.openappengine.gui.engine.core.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractGuiComponent implements GuiComponent {

	private static final long serialVersionUID = 1L;
	
	protected final Logger logger = Logger.getLogger(getClass());

	private final List<GuiComponent> childComponents = new ArrayList<GuiComponent>();
	
	private String id;
	
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

	public boolean hasChildren() {
		return !childComponents.isEmpty();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		Assert.notNull(id,"Id cannot be null.");
		this.id = id;
	}
}
