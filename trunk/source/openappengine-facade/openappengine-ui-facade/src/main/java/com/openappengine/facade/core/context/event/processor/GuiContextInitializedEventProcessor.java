package com.openappengine.facade.core.context.event.processor;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;
import com.openappengine.facade.core.component.widget.Widget;
import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;
import com.openappengine.facade.core.variable.VariableResolver;

public class GuiContextInitializedEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		logger.info("Processing Context Initialized Event.");
		
		//Add Root to the Model Map.
		GuiRootComponent root = context.getUIRoot();
		context.getExternalContext().addModelMapAttribute("uiRoot", root);
		
		//Resolve Components Value Refs
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
		
		//Form Widget. If component is a Form Widget add the model attribute.
		mergeFormWidgetModel(context, guiComponent);
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void mergeFormWidgetModel(GuiApplicationContext context,
			GuiComponent guiComponent) {
		if(guiComponent instanceof Widget) {
			Object formBackingObject = ((Widget) guiComponent).formBackingObject();
			context.getExternalContext().addModelMapAttribute(guiComponent.getId(), formBackingObject);
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