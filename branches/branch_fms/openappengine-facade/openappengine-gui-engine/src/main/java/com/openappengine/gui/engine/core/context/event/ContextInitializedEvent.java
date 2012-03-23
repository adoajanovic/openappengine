/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 5, 2012
 */
public class ContextInitializedEvent extends GuiContextEvent {

	private static final long serialVersionUID = 1L;
	
	public ContextInitializedEvent(GuiEngineContext source) {
		super(source);
	}

}
