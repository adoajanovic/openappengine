package com.openappengine.facade.core.context.event.processor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.component.executable.PreRenderActionsComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;
import com.openappengine.facade.core.executor.action.ActionDispatcher;
import com.openappengine.facade.core.executor.action.dispatcher.ActionDispatcherFactory;


public class GuiContextRestoreEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private static final Logger logger = Logger.getLogger("GuiContextRestoreEvent");
	
	private ActionDispatcherFactory actionDispatcherFactory = new ActionDispatcherFactory();
	
	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		Assert.notNull(context, "Context Null !");
		GuiRootComponent uiRoot = context.getUIRoot();
		context.postRootConstruction();
		handlePreRenderActions(context, uiRoot);
	}

	/**
	 * Handle PreRender Actions.
	 * 
	 * @param context
	 * @param uiRoot
	 */
	protected void handlePreRenderActions(GuiApplicationContext context,
			GuiRootComponent uiRoot) {
		PreRenderActionsComponent preRenderActionComponent = uiRoot.getPreRenderActionComponent();
		
		if (preRenderActionComponent == null
				|| preRenderActionComponent.getChildComponents() == null
				|| preRenderActionComponent.getChildComponents().isEmpty()) {
			logger.debug("No Pre-Render Actions defined.");
		} else {
			logger.debug("Executing Pre-Render Actions.");
			
			for (GuiComponent guiComponent : preRenderActionComponent.getChildComponents()) {
				if(guiComponent instanceof AbstractExecutableComponent) {
					logger.debug("Calling PreRenderAction : " + guiComponent.getComponentName());
					
					doHandlePreRenderAction(context, (AbstractExecutableComponent) guiComponent);
					
					logger.debug("PreRenderAction : " + guiComponent.getComponentName() + " complete.");
				}
			}
		}
	}

	/**
	 * Execute Individual Pre-Render Component Action.
	 * @param context
	 * @param guiComponent
	 */
	protected void doHandlePreRenderAction(GuiApplicationContext context,AbstractExecutableComponent exec) {
		
		if(exec.hasValueField()) {
			String valueField = exec.getValueField();
		}
		
		ActionRequest actionRequest = exec.createActionRequest();
		
		ActionDispatcher actionDispatcher = actionDispatcherFactory.createActionDispatcher(context.getELContext(), context.getExternalContext(), context.getMessageContext());
		
		Object result = actionDispatcher.execute(actionRequest);
		if(exec.hasValueField()) {
			String valueField = exec.getValueField();
			context.registerVariable(valueField, result);
		}
	}

}
