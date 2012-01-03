/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import java.util.Set;

import org.reflections.Reflections;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.registry.DefaultActionHandlerFactory;

class ActionHandlerFactoryInitializationCallback implements Callback<ActionHandlerFactory> {

	private String packageToScan = "com.openappengine.facade.core.executor.action";
	
	public ActionHandlerFactoryInitializationCallback() {
	}

	@Override
	public ActionHandlerFactory onCallback() {
		ActionHandlerFactory factory = new DefaultActionHandlerFactory();
		try {
			Reflections reflections = new Reflections(packageToScan);
			Set<Class<? extends ActionHandler>> actionHandlers = reflections.getSubTypesOf(ActionHandler.class);
			if (actionHandlers != null && !actionHandlers.isEmpty()) {
				for (Class<? extends ActionHandler> clazz : actionHandlers) {
					ActionHandler actionHandler = clazz.newInstance();
					factory.registerActionHandler(actionHandler.getName(), actionHandler);
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
		}
		return factory;
	}
}