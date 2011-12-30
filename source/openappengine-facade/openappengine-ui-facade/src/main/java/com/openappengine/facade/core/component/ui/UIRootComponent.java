/**
 * 
 */
package com.openappengine.facade.core.component.ui;

import com.openappengine.facade.core.component.AbstractXmlScreenComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class UIRootComponent extends AbstractXmlScreenComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentType() {
		return "root-container";
	}

	@Override
	public String getComponentName() {
		return "screen";
	}

}
