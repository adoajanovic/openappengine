package com.openappengine.facade.core.context.event.processor;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;
import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;
import com.openappengine.facade.core.variable.VariableResolver;

public class GuiContextInitializedEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		logger.info("Processing Context Initialized Event.");
		resolveGuiComponentValueRef(context.getUIRoot().getPageContent(), context);
	}

	private void resolveGuiComponentValueRef(GuiComponent root, GuiApplicationContext context) {
		resolveValueRef(context, root);
		if (root.hasChildren()) {
			for (GuiComponent guiComponent : root.getChildComponents()) {
				resolveGuiComponentValueRef(guiComponent, context);
			}
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void resolveValueRef(GuiApplicationContext context, GuiComponent guiComponent) {
		if (guiComponent instanceof ValueRefAware<?>) {
			doResolveValueRef(context, guiComponent);
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void doResolveValueRef(GuiApplicationContext context, GuiComponent guiComponent) {
		//TODO - Not used the isValueSet method.
		String valueRef = ((ValueRefAware) guiComponent).getValueRef();
		VariableResolver variableResolver = context.getVariableResolver();
		Object value = variableResolver.getValue(valueRef);
		((ValueRefAware) guiComponent).setValue(value);
	}
}
