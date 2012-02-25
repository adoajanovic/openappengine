package com.openappengine.gui.engine.core.context.event.processor;

import org.apache.log4j.Logger;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.component.ui.ValueRefAware;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.context.event.ContextPostRestoreEvent;
import com.openappengine.gui.engine.core.widget.Widget;

public class GuiContextPostRestoreEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	private static final Logger logger = Logger.getLogger(ContextPostRestoreEvent.class);

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event, GuiEngineContext context) {
		logger.info("Processing PostRestoreContext Events.");
		
		//Resolve Components Value Refs
		processGuiComponents(context.getUIRoot().getPageContent(), context);
	}

	private void processGuiComponents(GuiComponent root, GuiEngineContext context) {
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
	private void readValueRefAwareComponents(GuiEngineContext context, GuiComponent guiComponent) {
		if (guiComponent instanceof ValueRefAware<?>) {
			addReferencedWidget(context, (ValueRefAware) guiComponent);
		}
	}

	/**
	 * @param context
	 * @param guiComponent
	 */
	private void addReferencedWidget(GuiEngineContext context, ValueRefAware guiComponent) {
		String valueRef = guiComponent.getValueRef();
		if(guiComponent instanceof Widget) {
			context.addValueReferencedWidget(valueRef, (Widget) guiComponent);
		}
	}
}
