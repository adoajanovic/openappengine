/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import com.openappengine.facade.core.component.AbstractGuiComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public abstract class AbstractExecutableGuiComponent extends AbstractGuiComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public String getComponentType() {
		return "executable";
	}

}
