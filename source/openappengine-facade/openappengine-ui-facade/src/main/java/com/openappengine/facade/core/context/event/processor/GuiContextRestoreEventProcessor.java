package com.openappengine.facade.core.context.event.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.component.executable.PreRenderActionsComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;
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
		
		registerUnResolvedVariables(context, uiRoot);
		
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
	 * @param context
	 * @param uiRoot
	 */
	protected void registerUnResolvedVariables(GuiApplicationContext context, GuiRootComponent uiRoot) {
		Map<String, List<GuiComponent>> unResolvedGuiComponentsMap = evaluateUnResolvedGuiComponents(uiRoot);
		context.setUnresolvedGuiComponents(unResolvedGuiComponentsMap);
	}

	/**
	 * @param uiRoot
	 */
	protected Map<String,List<GuiComponent>> evaluateUnResolvedGuiComponents(GuiRootComponent uiRoot) {
		Map<String,List<GuiComponent>> unresolvedGuiComponents = new HashMap<String,List<GuiComponent>>();
		List<GuiComponent> children = uiRoot.getChildComponents();
		
		if(children != null && !children.isEmpty()) {
			for (GuiComponent guiComponent : children) {
				if(guiComponent instanceof AbstractGuiComponent) {
					doEvaluateUnResolvedGuiComponents(unresolvedGuiComponents,(AbstractGuiComponent) guiComponent);
				}
			}
		}
		return unresolvedGuiComponents;
	}

	/**
	 * @param unresolvedGuiComponents
	 * @param guiComponent
	 */
	private void doEvaluateUnResolvedGuiComponents(Map<String,List<GuiComponent>> unresolvedGuiComponents, AbstractGuiComponent guiComponent) {
		
		if(guiComponent.getClass().isAssignableFrom(ValueRefAware.class)) {
			ValueRefAware<?> valueRefAwareComponent = (ValueRefAware<?>) guiComponent;
			String valueRef = valueRefAwareComponent.getValueRef();
			
			if(unresolvedGuiComponents.containsKey(valueRef)) {
				unresolvedGuiComponents.get(valueRef).add(guiComponent);
			} else {
				List<GuiComponent> list = new ArrayList<GuiComponent>();
				list.add(guiComponent);
				unresolvedGuiComponents.put(valueRef,list);
			}
			
		}
		
		List<GuiComponent> children = guiComponent.getChildComponents();
		if (children != null && !children.isEmpty()) {
			for (GuiComponent uiComponent : children) {
				if (uiComponent instanceof AbstractGuiComponent) {
					if(guiComponent instanceof AbstractGuiComponent) {
						doEvaluateUnResolvedGuiComponents(unresolvedGuiComponents, (AbstractGuiComponent) uiComponent);
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
