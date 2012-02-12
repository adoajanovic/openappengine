/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import com.openappengine.gui.engine.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class ContextPostRestoreEvent extends GuiContextEvent {

	private static final long serialVersionUID = 1L;

	public ContextPostRestoreEvent(GuiApplicationContext source) {
		super(source);
	}
}