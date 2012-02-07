/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class PojoFormSingleWidgetProcessor extends HibernateEntityValueBackingBeanWidgetProcessor {

	@Override
	public String getProcessedWidgetType() {
		return "form-single";
	}

	protected void doProcessWidget() {
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
	}
}
