/**
 * 
 */
package com.openappengine.gui.engine.core.component.ui.container;
import com.openappengine.gui.engine.core.component.AbstractGuiComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class WidgetContainer extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getComponentType() {
		return "container";
	}

	@Override
	public String getComponentName() {
		return "widget";
	}
}
