/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.openappengine.facade.core.component.widget.context.HibernateBackingBeanWigetProcessorContext;
import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class FormSingleWidgetProcessor implements WidgetProcessor {

	private HibernateBackingBeanWigetProcessorContext context;
	
	@Override
	public String getProcessedWidgetType() {
		return "form-single";
	}

	@Override
	public Object processWidget() {
		EntityValue entityValue = null;
		try {
			Object backingBeanInstance = context.getWidgetBackingClass().newInstance();
			// TODO - Validate and bind
			// TODO - If Valid bind.
			
			
			ServletRequestDataBinder binder = new ServletRequestDataBinder(backingBeanInstance);
			binder.bind((ServletRequest) context.getExternalContext().getRequest());

			entityValue = (EntityValue) context.getELContext().getVariable(context.getWidgetBackingObjectValueRef());
			entityValue.setInstance(backingBeanInstance);

			// Replace the ModelMap attribute with the new binded instance.
			context.getExternalContext().getModelMap().addAttribute(context.getWidgetId(), backingBeanInstance);

			// Replace the EntityValue value-field in the ELContext with the new
			// binded EntityValue.
			context.getELContext().registerELContextVariable(context.getWidgetBackingObjectValueRef(), entityValue);

			// TODO- Check transition triggered and perform Transition.
			String triggeredTransition = context.getTriggeredTransition();
			if (StringUtils.isNotEmpty(triggeredTransition)) {
				TransitionEvent transitionEvent = new TransitionEvent(triggeredTransition,context.getExternalContext(),context.getELContext(),context.getMessageContext());
				context.getTransitionEventListener().onApplicationEvent(transitionEvent);
			}

		} catch (Throwable e) {
			// TODO - Handle
			e.printStackTrace();
		}
		return entityValue;
	}

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		if(context == null) {
			throw new IllegalArgumentException("WidgetProcessorContext cannot be null.");
		}
		if(!supportsWidgetProcessorContext(context.getClass())) {
			throw new IllegalArgumentException(
					"WidgetProcessor does not support the WidgetProcessorContext class:"
							+ context.getClass()
							+ ". Should extend from "
							+ HibernateBackingBeanWigetProcessorContext.class
									.getName() + ".");
		}
		this.context = (HibernateBackingBeanWigetProcessorContext) context;
	}

	public boolean supportsWidgetProcessorContext(Class<?> clazz) {
		if(clazz == null || getWidgetProcessorContextClass() == null) {
			return false;
		}
		return getWidgetProcessorContextClass().isAssignableFrom(clazz);
	}
	
	@Override
	public Class<?> getWidgetProcessorContextClass() {
		return HibernateBackingBeanWigetProcessorContext.class;
	}

}
