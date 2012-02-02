/**
 * 
 */
package com.openappengine.facade.core.context.event.processor;

import com.openappengine.facade.core.context.ApplicationEvent;
import com.openappengine.facade.core.context.GuiApplicationContext;
import com.openappengine.facade.core.context.LifecycleEventProcessor;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class UpdateMessageEventProcessor implements LifecycleEventProcessor<GuiApplicationContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiApplicationContext> event,GuiApplicationContext context) {
		//Add MessageContext messages.
		context.getExternalContext().addModelMapAttribute("contextMessages", context.getMessageContext().getAllMessages());
		context.getExternalContext().addModelMapAttribute("errorMessages", context.getMessageContext().getErroMessages());
		context.getExternalContext().addModelMapAttribute("successMessages", context.getMessageContext().getSuccessMessages());
		context.getExternalContext().addModelMapAttribute("infoMessages", context.getMessageContext().getInfoMessages());
		context.getExternalContext().addModelMapAttribute("warningMessages", context.getMessageContext().getWarningMessages());
	}

}

