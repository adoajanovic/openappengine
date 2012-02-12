/**
 * 
 */
package com.openappengine.gui.engine.core.component.value;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;

/**
 * @author hrishi
 * since Dec 31, 2011
 */
public abstract class AbstractValueHolderComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentType() {
		return "value-holder";
	}

}
