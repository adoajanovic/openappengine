/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class GuiContextMessageRefreshEvent extends GuiContextEvent {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param source
	 */
	public GuiContextMessageRefreshEvent(GuiEngineContext source) {
		super(source);
	}


}
