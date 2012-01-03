/**
 * 
 */
package com.openappengine.facade.core.executor.action.dispatcher;

import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.util.Assert;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.context.factory.FactoryConstants;
import com.openappengine.facade.context.factory.FactoryFinder;
import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerFactory;
import com.openappengine.facade.core.executor.action.ActionHandlerWrapper;
import com.openappengine.facade.core.executor.action.registry.DefaultActionHandlerFactory;

/**
 * @author hrishikesh.joshi
 * @since Jan 2, 2012
 */
public class SimpleActionDispatcher implements ActionDispatcher {
	
	private ActionHandlerFactory factory;
	
	public SimpleActionDispatcher() {
		factory = (ActionHandlerFactory) FactoryFinder.getFactory(FactoryConstants.ACTION_HANDLER_FACTORY,
				new ActionHandlerFactoryInitializationCallback());
	}
	
	@Override
	public Object execute(ActionRequest actionRequest) {
		Assert.notNull(actionRequest, "Action Request cannot be empty.");
		
		// Get ActionHandler from the Input Action Name.
		String actionName = actionRequest.getActionName();
		ActionHandler actionHandler = factory.getActionHandler(actionName);
		Assert.notNull(actionHandler, "ActionHandler not found in the Factory.");
		
		ActionHandlerWrapper wrapper = new ActionHandlerWrapper(actionHandler);
		Map<String, Object> actionParameters = actionRequest.getActionParameters();
		if(actionParameters != null) {
			Set<String> actionParams = actionParameters.keySet();
			for (String param : actionParams) {
				wrapper.put(param, actionParameters.get(param));
			}
		}
		
		actionHandler.execute();
		
		return null;
	}

	private class ActionHandlerFactoryInitializationCallback implements Callback<ActionHandlerFactory> {

		private String packageToScan = "com.openappengine.facade.core.executor.action";
		
		public ActionHandlerFactoryInitializationCallback() {
		}

		@Override
		public ActionHandlerFactory onCallback() {
			try {
				ActionHandlerFactory factory = new DefaultActionHandlerFactory();
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
}
