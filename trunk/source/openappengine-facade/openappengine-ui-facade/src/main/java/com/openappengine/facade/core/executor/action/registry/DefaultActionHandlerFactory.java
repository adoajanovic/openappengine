/**
 * 
 */
package com.openappengine.facade.core.executor.action.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class DefaultActionHandlerFactory implements ActionHandlerFactory {
	
	private static final Map<String,ActionHandler> cachedActionHandlers = new ConcurrentHashMap<String, ActionHandler>();

	@Override
	public ActionHandler getActionHandler(String name) {
		if(!cachedActionHandlers.containsKey(name)) {
			throw new ActionRegistryExecption("ActionHandler : " + name + " not found in the ActionHandlerFactory.");
		}
		return cachedActionHandlers.get(name);
	}

	@Override
	public void registerActionHandler(String name, ActionHandler actionHandler) {
		cachedActionHandlers.put(name, actionHandler);
	}

}
