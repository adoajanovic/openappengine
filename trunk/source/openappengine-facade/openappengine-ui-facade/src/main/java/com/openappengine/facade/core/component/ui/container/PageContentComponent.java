package com.openappengine.facade.core.component.ui.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.openappengine.facade.context.factory.xml.NodeNames;
import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.GuiComponent;

public class PageContentComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getComponentType() {
		return "container";
	}

	@Override
	public String getComponentName() {
		return "page-content";
	}
	
	/**
	 * @return - An unmodifiable list of Widgets.
	 */
	public List<WidgetsComponent> getWidgets() {
		final List<WidgetsComponent> widgetsComponents = new ArrayList<WidgetsComponent>();
		for(GuiComponent guiComponent : getChildComponents()) {
			if(guiComponent.getComponentName().equals(NodeNames.WIDGETS)) {
				widgetsComponents.add((WidgetsComponent) guiComponent);
			}
		}
		return Collections.unmodifiableList(widgetsComponents);
	}
	
}
