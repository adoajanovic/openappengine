/**
 * 
 */
package com.openappengine.facade.core.context;

/**
 * Represents the Lifecycle Strategy for the GUI Application Context.
 * 
 * @author hrishikesh.joshi
 * @since Jan 4, 2012
 */
public interface LifecycleEventProcessor<T> {

	void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event,T t);
}
