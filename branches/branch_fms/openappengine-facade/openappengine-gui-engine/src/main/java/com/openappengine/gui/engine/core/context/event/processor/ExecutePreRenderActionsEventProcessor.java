package com.openappengine.gui.engine.core.context.event.processor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.component.executable.PreRenderActions;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.executor.action.ActionDispatcher;
import com.openappengine.gui.engine.core.executor.action.dispatcher.ActionDispatcherFactory;
import com.openappengine.gui.engine.core.widget.Widget;


public class ExecutePreRenderActionsEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	private static final Logger logger = Logger.getLogger("GuiContextRestoreEvent");
	
	private ActionDispatcherFactory actionDispatcherFactory = new ActionDispatcherFactory();
	
	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event, GuiEngineContext context) {
		Assert.notNull(context, "Context Null !");
		context.postRootConstruction();
		handlePreRenderActions(context);
	}

	/**
	 * Handle PreRender Actions.
	 * 
	 * @param context
	 */
	protected void handlePreRenderActions(GuiEngineContext context) {
		
		PreRenderActions preRenderActions = context.getPreRenderActions();
		
		if (preRenderActions == null
				|| preRenderActions.getChildComponents() == null
				|| preRenderActions.getChildComponents().isEmpty()) {
			logger.debug("No Pre-Render Actions defined.");
		} else {
			logger.debug("Executing Pre-Render Actions.");
			for (GuiComponent guiComponent : preRenderActions.getChildComponents()) {
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
	protected void doHandlePreRenderAction(GuiEngineContext context,AbstractExecutableComponent exec) {
		ActionDispatcher actionDispatcher = actionDispatcherFactory
				.createActionDispatcher(context.getELContext(),
										context.getExternalContext(),
										context.getMessageContext(),exec);
		
		ActionResponseXml actionResponseXml = actionDispatcher.execute();
		
		if (exec.hasValueField()) {
			String valueField = exec.getValueField();
			context.getELContext().registerELContextVariable(valueField, actionResponseXml.getResponseDocument());
		}
		
	}

	

}
