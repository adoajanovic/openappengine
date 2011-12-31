/**
 * 
 */
package com.openappengine.facade.core.component.ui;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.AbstractXmlScreenComponent;
import com.openappengine.facade.core.component.XmlScreenComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractUIComponent extends AbstractXmlScreenComponent {

	private static final long serialVersionUID = 1L;
	
	private List<XmlScreenComponent> childComponents = new ArrayList<XmlScreenComponent>();

	/**
	 * @return the childComponents
	 */
	public List<XmlScreenComponent> getChildComponents() {
		return childComponents;
	}

	/**
	 * @param childComponents the childComponents to set
	 */
	protected void setChildComponents(List<XmlScreenComponent> childComponents) {
		this.childComponents = childComponents;
	}

	/**
	 * Add Child Component to this component.
	 * @param screenComponent
	 * @return
	 */
	public boolean addChildComponent(XmlScreenComponent screenComponent) {
		if(screenComponent == null) {
			return false;
		}
		return childComponents.add(screenComponent);
	}
}
