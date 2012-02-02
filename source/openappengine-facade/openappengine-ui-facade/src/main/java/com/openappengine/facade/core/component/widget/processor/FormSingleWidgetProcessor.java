/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import org.apache.commons.lang.StringUtils;

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

	protected EntityValue doProcessWidget(EntityValue entityValue) {
		try {
			String triggeredTransition = getWidgetProcessorContext().getTriggeredTransition();
			if (StringUtils.isNotEmpty(triggeredTransition)) {
				TransitionEvent transitionEvent = createTransitionEvent(triggeredTransition);
				getWidgetProcessorContext().getTransitionEventListener().onApplicationEvent(transitionEvent);
			}
		} catch (Throwable e) {
			// TODO - Handle
			e.printStackTrace();
		}
		return entityValue;
	}
}
