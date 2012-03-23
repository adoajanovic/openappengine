/**
 * 
 */
package com.openappengine.gui.engine.core.context;

/**
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public interface EventMulticaster {

	/**
	 * Add ApplicationEvent Listener.
	 * @param e
	 */
	void registerEventListener(ApplicationEvent e);
	
	/**
	 * Multicast the ApplicationEvent to all the listeners of this event.
	 * @param e
	 */
	void multicastApplicationEvent(ApplicationEvent e);
}
