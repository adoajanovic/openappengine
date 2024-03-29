/**
 * 
 */
package com.openappengine.gui.engine.core.component.executable;

import org.apache.commons.lang.StringUtils;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;
import com.openappengine.gui.engine.core.component.GuiComponent;

/**
 * Abstract Super Class for all the executable components of the Gui Component Tree.
 * 
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractExecutableComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;

	private String valueField;
	
	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	@Override
	public String getComponentType() {
		return "executable";
	}
	
	public boolean hasValueField() {
		return StringUtils.isNotEmpty(valueField);
	}

	/**
	 * Add an executable child Component to this component.
	 * 
	 * @param component
	 * @return
	 */
	public boolean addChildComponent(GuiComponent component) {
		if (component == null) {
			return false;
		}
		if (component instanceof AbstractExecutableComponent) {
			return getChildComponents().add(component);
		} else {
			logger.error("Only an executable component can be added to the executable component node.");
			return false;
		}
	}

}
