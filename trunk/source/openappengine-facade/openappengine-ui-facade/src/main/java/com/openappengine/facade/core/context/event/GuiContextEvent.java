/**
 * 
 */
package com.openappengine.facade.core.context.event;

import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public abstract class GuiContextEvent extends ApplicationEvent<GuiApplicationContext> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param source
	 */
	public GuiContextEvent(GuiApplicationContext source) {
		super(source);
	}

}
