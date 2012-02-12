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
	
	private static final Map<String,Class<? extends ActionHandler>> cachedActionHandlers = new ConcurrentHashMap<String, Class<? extends ActionHandler>>();
	
	@Override
	public ActionHandler getActionHandler(String name) {
		if(!cachedActionHandlers.containsKey(name)) {
			throw new ActionRegistryExecption("ActionHandler : " + name + " not found in the ActionHandlerFactory.");
		}
		Class<? extends ActionHandler> clazz = cachedActionHandlers.get(name);
		ActionHandler actionHandlerInstance = null;
		try {
			actionHandlerInstance = clazz.newInstance();
			return actionHandlerInstance;
		} catch (InstantiationException e) {
			throw new ActionHandlerInitializationException("Class " + clazz.getName() + " cannot be instantiated.");
		} catch (IllegalAccessException e) {
			throw new ActionHandlerInitializationException("Illegal Access to Class " + clazz.getName() + ".");
		} 
	}
	

	@Override
	public void registerActionHandler(String name, Class<? extends ActionHandler> actionHandlerClass) {
		cachedActionHandlers.put(name, actionHandlerClass);
	}
	
}
