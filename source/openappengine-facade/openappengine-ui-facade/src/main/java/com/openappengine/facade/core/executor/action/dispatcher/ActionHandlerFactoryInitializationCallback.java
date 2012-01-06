/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import java.lang.reflect.Modifier;
import java.util.Set;

import org.reflections.Reflections;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.registry.DefaultActionHandlerFactory;

public class ActionHandlerFactoryInitializationCallback implements Callback<ActionHandlerFactory> {

	private String packageToScan = "com.openappengine.facade.core.executor.action";
	
	public ActionHandlerFactoryInitializationCallback() {
	}

	@Override
	public ActionHandlerFactory onCallback() {
		ActionHandlerFactory factory = new DefaultActionHandlerFactory();
		Reflections reflections = new Reflections(packageToScan);
		Set<Class<? extends ActionHandler>> actionHandlers = reflections.getSubTypesOf(ActionHandler.class);
		if (actionHandlers != null && !actionHandlers.isEmpty()) {
			for (Class<? extends ActionHandler> clazz : actionHandlers) {
				doRegisterActionHandler(factory, clazz);
			}
		}
		return factory;
	}

	/**
	 * @param factory
	 * @param clazz
	 * @throws ActionHandlerFactoryInitializationException
	 */
	private void doRegisterActionHandler(ActionHandlerFactory factory, Class<? extends ActionHandler> clazz)
			throws ActionHandlerFactoryInitializationException {
		try {
			if(Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
				return;
			}
			ActionHandler actionHandler = clazz.newInstance();
			factory.registerActionHandler(actionHandler.getName(), actionHandler);
		} catch (InstantiationException e) {
			throw new ActionHandlerFactoryInitializationException("Exception encountered while initializing ActionHandler for class " + clazz);
		} catch (IllegalAccessException e) {
			throw new ActionHandlerFactoryInitializationException("Exception encountered while accessing ActionHandler for class " + clazz);
		}
	}
	
	private class ActionHandlerFactoryInitializationException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ActionHandlerFactoryInitializationException(String message) {
			super(message);
		}
	}
}