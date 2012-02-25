/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class UpdateMessageEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event,GuiEngineContext context) {
		//Add MessageContext messages.
		context.getExternalContext().addModelMapAttribute("contextMessages", context.getMessageContext().getAllMessages());
		context.getExternalContext().addModelMapAttribute("errorMessages", context.getMessageContext().getErrorMessages());
		context.getExternalContext().addModelMapAttribute("successMessages", context.getMessageContext().getSuccessMessages());
		context.getExternalContext().addModelMapAttribute("infoMessages", context.getMessageContext().getInfoMessages());
		context.getExternalContext().addModelMapAttribute("warningMessages", context.getMessageContext().getWarningMessages());
	}

}

