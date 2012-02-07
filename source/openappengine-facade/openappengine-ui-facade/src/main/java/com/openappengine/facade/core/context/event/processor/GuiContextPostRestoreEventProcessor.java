package com.openappengine.facade.core.context.event.processor;

import org.apache.log4j.Logger;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.ui.ValueRefAware;
import com.openappengine.facade.core.component.widget.Widget;
import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;

public class GuiContextPostRestoreEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	private static final Logger logger = Logger.getLogger("PostRestore");

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event, GuiApplicationContext context) {
		logger.info("Processing PostRestoreContext Events.");
		
		//Resolve Components Value Refs
		processGuiComponents(context.getUIRoot().getPageContent(), context);
	}

	private void processGuiComponents(GuiComponent root, GuiApplicationContext context) {
		readValueRefAwareComponents(context, root);
		if (root.hasChildren()) {
			for (GuiComponent guiComponent : root.getChildComponents()) {
				processGuiComponents(guiComponent, context);
			}
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void readValueRefAwareComponents(GuiApplicationContext context, GuiComponent guiComponent) {
		if (guiComponent instanceof ValueRefAware<?>) {
			addReferencedWidget(context, (ValueRefAware) guiComponent);
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void addReferencedWidget(GuiApplicationContext context, ValueRefAware guiComponent) {
		String valueRef = guiComponent.getValueRef();
		if(guiComponent instanceof Widget) {
			context.addValueReferencedWidget(valueRef, (Widget) guiComponent);
		}
	}
}
