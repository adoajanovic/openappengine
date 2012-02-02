/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class FormSingleWidgetProcessor extends HibernateEntityValueBackingBeanWidgetProcessor {

	@Override
	public String getProcessedWidgetType() {
		return "form-single";
	}

	@Override
	public EntityValue processWidget() {
		EntityValue entityValue = null;
		try {
			Object backingBeanInstance = getWidgetProcessorContext().getWidgetBackingClass().newInstance();
			// TODO - Validate and bind
			// TODO - If Valid bind.
			
			
			ServletRequestDataBinder binder = new ServletRequestDataBinder(backingBeanInstance);
			binder.bind((ServletRequest) getWidgetProcessorContext().getExternalContext().getRequest());

			entityValue = (EntityValue) getWidgetProcessorContext().getELContext().getVariable(getWidgetProcessorContext().getWidgetBackingObjectValueRef());
			entityValue.setInstance(backingBeanInstance);

			String triggeredTransition = getWidgetProcessorContext().getTriggeredTransition();
			if (StringUtils.isNotEmpty(triggeredTransition)) {
				TransitionEvent transitionEvent = new TransitionEvent(triggeredTransition,getWidgetProcessorContext().getExternalContext(),getWidgetProcessorContext().getELContext(),getWidgetProcessorContext().getMessageContext());
				getWidgetProcessorContext().getTransitionEventListener().onApplicationEvent(transitionEvent);
			}

			//If the EntityValue has not been removed from the ELContext, then bind the model map with the entityvalue instance.
			if(getWidgetProcessorContext().getELContext().getVariable(getWidgetProcessorContext().getWidgetBackingObjectValueRef()) != null) {
				// Replace the ModelMap attribute with the new binded instance.
				getWidgetProcessorContext().getExternalContext().getModelMap().addAttribute(getWidgetProcessorContext().getWidgetId(), entityValue.getInstance());
			}

			//TODO - Moved to the ActionHandler.
			/*
			// Replace the EntityValue value-field in the ELContext with the new binded EntityValue.
			context.getELContext().registerELContextVariable(context.getWidgetBackingObjectValueRef(), entityValue);
			*/

		} catch (Throwable e) {
			// TODO - Handle
			e.printStackTrace();
		}
		return entityValue;
	}

}
