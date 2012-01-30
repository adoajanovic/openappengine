/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class FormWidgetProcessor implements WidgetProcessor {

	@Override
	public String getProcessedWidgetType() {
		return "form-single";
	}

	@Override
	public Object processWidget(WidgetProcessorContext context) {
		try {
			Object bindedInstance = context.getWidgetBackingClass().newInstance();
			ServletRequestDataBinder binder = new ServletRequestDataBinder(bindedInstance);
			// TODO - Validate and bind
			// TODO - If Valid bind.
			binder.bind((ServletRequest) context.getExternalContext().getRequest());

			EntityValue entityValue = (EntityValue) context.getELContext().getVariable(context.getWidgetBackingObjectValueRef());
			entityValue.setInstance(bindedInstance);

			// Replace the ModelMap attribute with the new binded instance.
			context.getExternalContext().getModelMap().addAttribute(context.getWidgetId(), bindedInstance);

			// Replace the EntityValue value-field in the ELContext with the new
			// binded EntityValue.
			context.getELContext().registerELContextVariable(context.getWidgetBackingObjectValueRef(), entityValue);

			// TODO- Check transition triggered and perform Transition.
			String triggeredTransition = context.getTriggeredTransition();
			if (StringUtils.isNotEmpty(triggeredTransition)) {
				TransitionEvent transitionEvent = new TransitionEvent(triggeredTransition,context.getExternalContext(),context.getELContext());
				context.getTransitionEventListener().onApplicationEvent(transitionEvent);
			}

		} catch (Throwable e) {
			// TODO - Handle
			e.printStackTrace();
		}
		return null;
	}

}
