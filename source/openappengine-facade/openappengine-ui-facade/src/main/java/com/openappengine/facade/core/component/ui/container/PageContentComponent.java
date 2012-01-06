package com.openappengine.facade.core.component.ui.container;

import com.openappengine.facade.core.component.AbstractGuiComponent;

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
	
}
