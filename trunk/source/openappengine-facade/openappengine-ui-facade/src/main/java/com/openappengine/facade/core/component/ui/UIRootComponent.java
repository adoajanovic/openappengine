/**
 * 
 */
package com.openappengine.facade.core.component.ui;

import com.openappengine.facade.core.component.AbstractXmlScreenComponent;
import com.openappengine.facade.core.component.executable.PreActionsComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public class UIRootComponent extends AbstractXmlScreenComponent {

	private static final long serialVersionUID = 1L;
	
	private PreActionsComponent preActionsComponent;

	@Override
	public String getComponentType() {
		return "root-container";
	}

	@Override
	public String getComponentName() {
		return "screen";
	}

	/**
	 * @return the preActionsComponent
	 */
	public PreActionsComponent getPreActionsComponent() {
		return preActionsComponent;
	}

	/**
	 * @param preActionsComponent the preActionsComponent to set
	 */
	public void setPreActionsComponent(PreActionsComponent preActionsComponent) {
		this.preActionsComponent = preActionsComponent;
	}

}
