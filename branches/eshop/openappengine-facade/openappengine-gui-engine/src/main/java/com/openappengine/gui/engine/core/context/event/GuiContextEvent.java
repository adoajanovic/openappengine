/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public abstract class GuiContextEvent extends ApplicationEvent<GuiEngineContext> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param source
	 */
	public GuiContextEvent(GuiEngineContext source) {
		super(source);
	}

}
