/**
 * 
 */
package com.openappengine.gui.engine.core.context.event;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.EventMulticaster;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public class GuiContextEventMulticaster implements EventMulticaster {

	private final List<ApplicationEvent> events = new ArrayList<ApplicationEvent>();
	
	@Override
	public void registerEventListener(ApplicationEvent e) {
		if(e == null) {
			return;
		}
		
		events.add(e);
	}

	@Override
	public void multicastApplicationEvent(ApplicationEvent e) {
	}

}
