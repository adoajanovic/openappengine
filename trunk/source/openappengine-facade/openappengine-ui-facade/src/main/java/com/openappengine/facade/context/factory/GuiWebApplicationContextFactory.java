/**
 * 
 */
package com.openappengine.facade.context.factory;

import org.springframework.core.io.Resource;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.WebGuiApplicationContext;
import com.openappengine.facade.core.context.event.ContextRestoreEvent;
import com.openappengine.facade.core.context.lifecycle.DefaultLifecycleProcessor;
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
			GuiApplicationContext context = new WebGuiApplicationContext();
			GuiRootComponent uiRoot = createGuiRoot(resource, context);
			uiRoot.setContext(context);

			//Context Restored.
			context = processLifecyleRestoreProcessing(context);
			
			//TODO - Handle States.
			registerScreenApplicationContext(resource, context);
		}
		return cachedGuiApplicationContexts.get(resource);
	}

	protected GuiApplicationContext processLifecyleRestoreProcessing(GuiApplicationContext context) {
		//Call the Restore Event Listener
		ContextRestoreEvent contextRestoreEvent = new ContextRestoreEvent(context);
		getLifecycleProcessor().processLifecycleEvent(contextRestoreEvent);
		
		return context;
	}

}
