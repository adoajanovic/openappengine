/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.component.ui.AbstractUIComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractExecutableComponent extends AbstractUIComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentType() {
		return "executable";
	}

}
