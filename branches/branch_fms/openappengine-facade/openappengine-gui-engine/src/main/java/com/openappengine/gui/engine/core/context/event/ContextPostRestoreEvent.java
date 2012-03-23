/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class ContextPostRestoreEvent extends GuiContextEvent {

	private static final long serialVersionUID = 1L;

	public ContextPostRestoreEvent(GuiEngineContext source) {
		super(source);
	}
}
