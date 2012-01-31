/**
 * 
 */
package com.openappengine.facade.core.context.event;

import com.openappengine.facade.core.context.GuiApplicationContext;

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
	public GuiContextMessageRefreshEvent(GuiApplicationContext source) {
		super(source);
	}


}
