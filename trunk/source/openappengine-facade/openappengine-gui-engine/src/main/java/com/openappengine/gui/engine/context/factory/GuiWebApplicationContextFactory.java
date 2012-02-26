/**
 * 
 */
package com.openappengine.gui.engine.context.factory;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.WebGuiApplicationContext;
import com.openappengine.gui.engine.core.context.event.ContextInitializedEvent;
import com.openappengine.gui.engine.core.context.event.ContextPostRestoreEvent;
import com.openappengine.gui.engine.core.context.event.ExecutePreRenderActionsEvent;
import com.openappengine.gui.engine.core.context.event.GuiContextMessageRefreshEvent;
import com.openappengine.gui.engine.core.context.event.TransformWidgetsEvent;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class GuiWebApplicationContextFactory extends AbstractGuiContextFactory {
	
	public GuiWebApplicationContextFactory() {
	}
	
	public GuiWebApplicationContextFactory(ContextConfiguration contextConfiguration) {
		super();
		this.setContextConfiguration(contextConfiguration);
	}
	
	@Override
	public GuiEngineContext createGuiEngineContext(Resource resource) {
		Document document = getScreenXmlDocument(resource);
		WebGuiApplicationContext context = new WebGuiApplicationContext(document);
		
		/*GuiRootComponent uiRoot = createGuiRoot(resource, context);
		uiRoot.setContext(context);*/
		registerGuiEngineContext(resource, context);
		return context;
	}

	@Override
	public void processLifecylePreRenderActions(GuiEngineContext guiEngineContext) {
		ExecutePreRenderActionsEvent executePreRenderActionsEvent = new ExecutePreRenderActionsEvent(guiEngineContext);
		getLifecycleProcessor().processLifecycleEvent(executePreRenderActionsEvent);
	}
	
	@Override
	public void processLifecylePostRestoreProcessing(
			GuiEngineContext applicationContext) {
		ContextPostRestoreEvent contextRestoreEvent = new ContextPostRestoreEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(contextRestoreEvent);
	}

	@Override
	public void processLifecycleInitializedEvent(
			GuiEngineContext applicationContext) {
		ContextInitializedEvent contextInitEvent = new ContextInitializedEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(contextInitEvent);
	}
	
	@Override
	public void processLifecycleTransformWidgetsEvent(GuiEngineContext applicationContext) {
		TransformWidgetsEvent event = new TransformWidgetsEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(event);
	}

	@Override
	public void refreshMessages(GuiEngineContext context) {
		GuiContextMessageRefreshEvent messageRefreshEvent = new GuiContextMessageRefreshEvent(context);
		getLifecycleProcessor().processLifecycleEvent(messageRefreshEvent);
	}

}
