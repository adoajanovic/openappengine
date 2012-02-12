/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.WebGuiApplicationContext;
import com.openappengine.facade.core.context.event.ContextInitializedEvent;
import com.openappengine.facade.core.context.event.ContextPostRestoreEvent;
import com.openappengine.facade.core.context.event.ExecutePreRenderActionsEvent;
import com.openappengine.facade.core.context.event.GuiContextMessageRefreshEvent;

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
	public GuiApplicationContext createGuiApplicationContext(Resource resource) {
		WebGuiApplicationContext context = new WebGuiApplicationContext();
		
		GuiRootComponent uiRoot = createGuiRoot(resource, context);
		uiRoot.setContext(context);
		
		registerScreenApplicationContext(resource, context);
		
		return context;
	}

	@Override
	public void processLifecylePreRenderActions(GuiApplicationContext applicationContext) {
		ExecutePreRenderActionsEvent executePreRenderActionsEvent = new ExecutePreRenderActionsEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(executePreRenderActionsEvent);
	}
	
	@Override
	public void processLifecylePostRestoreProcessing(
			GuiApplicationContext applicationContext) {
		ContextPostRestoreEvent contextRestoreEvent = new ContextPostRestoreEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(contextRestoreEvent);
	}

	@Override
	public void processLifecycleInitializedEvent(
			GuiApplicationContext applicationContext) {
		ContextInitializedEvent contextInitEvent = new ContextInitializedEvent(applicationContext);
		getLifecycleProcessor().processLifecycleEvent(contextInitEvent);
	}

	@Override
	public void refreshMessages(GuiApplicationContext context) {
		GuiContextMessageRefreshEvent messageRefreshEvent = new GuiContextMessageRefreshEvent(context);
		getLifecycleProcessor().processLifecycleEvent(messageRefreshEvent);
	}

}
