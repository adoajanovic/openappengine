/**
 * 
 */
package com.openappengine.gui.engine.core.context;

import java.util.EventListener;

/**
 * @author hrishikesh.joshi
 * @param <E extends ApplicationEvent>
 * @since Jan 4, 2012
 */
public interface ApplicationEventListener<E extends ApplicationEvent> extends EventListener {

	void onApplicationEvent(E event);
}
