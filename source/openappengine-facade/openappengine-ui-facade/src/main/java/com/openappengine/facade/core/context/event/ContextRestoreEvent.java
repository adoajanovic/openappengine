/**
 * 
 */
package com.openappengine.facade.core.context.event;

import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class ContextRestoreEvent extends ApplicationEvent<GuiApplicationContext> {

	private static final long serialVersionUID = 1L;

	public ContextRestoreEvent(GuiApplicationContext source) {
		super(source);
	}
}
