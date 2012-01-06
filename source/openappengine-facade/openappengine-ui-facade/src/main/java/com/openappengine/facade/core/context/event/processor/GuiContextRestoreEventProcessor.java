package com.openappengine.facade.core.context.event.processor;

import java.util.List;

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
import com.openappengine.facade.core.executor.action.dispatcher.SimpleActionDispatcher;


public class GuiContextRestoreEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private final ActionDispatcher actionDispatcher = new SimpleActionDispatcher();
	
	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		Assert.notNull(context, "Context Null !");
		GuiRootComponent uiRoot = context.getUIRoot();
		
		PreRenderActionsComponent preRenderActionComponent = uiRoot.getPreRenderActionComponent();
		if(preRenderActionComponent != null) {
			List<GuiComponent> guiComponents = preRenderActionComponent.getChildComponents();
			if(guiComponents != null && !guiComponents.isEmpty()) {
				for (GuiComponent guiComponent : guiComponents) {
					if(guiComponent instanceof AbstractExecutableComponent) {
						executePreRenderActionComponent(context, guiComponent);
					}
				}
			}
		}
		
	}

	/**
	 * Execute Individual Pre-Render Component Action.
	 * @param context
	 * @param guiComponent
	 */
	private void executePreRenderActionComponent(GuiApplicationContext context,
			GuiComponent guiComponent) {
		AbstractExecutableComponent exec = (AbstractExecutableComponent)guiComponent;
		ActionRequest actionRequest = exec.getActionRequest();
		
		Object result = actionDispatcher.execute(actionRequest);
		if(exec.hasValueField()) {
			String valueField = exec.getValueField();
			context.registerVariable(valueField, result);
		}
	}

}
