/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.dispatcher;

import java.lang.reflect.Modifier;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.core.annotation.AnnotationUtils;

import com.openappengine.gui.engine.context.factory.Callback;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;
import com.openappengine.gui.engine.core.executor.action.ActionHandlerFactory;
import com.openappengine.gui.engine.core.executor.action.registry.DefaultActionHandlerFactory;
import com.openappengine.gui.engine.core.executor.annotations.Action;

public class ActionHandlerFactoryInitializationCallback implements Callback<ActionHandlerFactory> {

	private String packageToScan = "com.openappengine.gui.engine.core.executor.action";
	
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
			
			Action action = AnnotationUtils.findAnnotation(clazz, Action.class);
			if(action != null) {
				String actionName = action.actionName();
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