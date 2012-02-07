/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import java.lang.reflect.Modifier;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.core.annotation.AnnotationUtils;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.registry.DefaultActionHandlerFactory;
import com.openappengine.facade.core.executor.annotations.ActionParams;

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
			if(Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
				return;
			}
			
			ActionParams actionParams = AnnotationUtils.findAnnotation(clazz, ActionParams.class);
			if(actionParams != null) {
				String actionName = actionParams.actionName();
				factory.registerActionHandler(actionName, clazz);
			}
	}
	
	private class ActionHandlerFactoryInitializationException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ActionHandlerFactoryInitializationException(String message) {
			super(message);
		}
	}
}