/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.WebGuiApplicationContext;
import com.openappengine.facade.core.context.event.ContextInitializedEvent;
import com.openappengine.facade.core.context.event.ContextRestoreEvent;
import com.openappengine.facade.core.ext.ExternalContext;

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
	public GuiApplicationContext createGuiApplicationContext(Resource resource,ExternalContext externalContext) {
		if(!contains(resource)) {
			GuiApplicationContext context = new WebGuiApplicationContext(externalContext);
			GuiRootComponent uiRoot = createGuiRoot(resource, context);
			uiRoot.setContext(context);

			processLifecyleRestoreProcessing(context);
			
			processLifecycleInitializedEvent(context);
			
			registerScreenApplicationContext(resource, context);
			
		}
		return cachedGuiApplicationContexts.get(resource);
	}

	/**
	 * Call the Initialized Event Listener
	 * @param context
	 */
	protected void processLifecycleInitializedEvent(GuiApplicationContext context) {
		ContextInitializedEvent contextInitEvent = new ContextInitializedEvent(context);
		getLifecycleProcessor().processLifecycleEvent(contextInitEvent);
	}

	/**
	 * Call the Restore Event Listener
	 * @param context
	 */
	protected void processLifecyleRestoreProcessing(GuiApplicationContext context) {
		ContextRestoreEvent contextRestoreEvent = new ContextRestoreEvent(context);
		getLifecycleProcessor().processLifecycleEvent(contextRestoreEvent);
	}

}
