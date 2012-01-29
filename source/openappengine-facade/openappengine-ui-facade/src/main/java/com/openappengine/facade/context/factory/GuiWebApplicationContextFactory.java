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
import com.openappengine.facade.core.el.ExpressionEvaluator;
import com.openappengine.facade.core.el.SimpleExpressionEvaluator;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.fsm.TransitionEventListener;

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
		WebGuiApplicationContext context = new WebGuiApplicationContext(externalContext);
		
		GuiRootComponent uiRoot = createGuiRoot(resource, context);
		uiRoot.setContext(context);
		
		registerScreenApplicationContext(resource, context);
		
		return context;
	}

	/**
	 * Call the Initialized Event Listener
	 * @param context
	 */
	public void processLifecycleInitializedEvent(GuiApplicationContext context) {
		ContextInitializedEvent contextInitEvent = new ContextInitializedEvent(context);
		getLifecycleProcessor().processLifecycleEvent(contextInitEvent);
	}

	/**
	 * Call the Restore Event Listener
	 * @param context
	 */
	public void processLifecyleRestoreProcessing(GuiApplicationContext context) {
		ContextRestoreEvent contextRestoreEvent = new ContextRestoreEvent(context);
		getLifecycleProcessor().processLifecycleEvent(contextRestoreEvent);
	}

}
