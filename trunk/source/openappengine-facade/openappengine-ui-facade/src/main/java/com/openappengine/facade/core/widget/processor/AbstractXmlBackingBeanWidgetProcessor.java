/**
 * 
 */
package com.openappengine.facade.core.widget.processor;

import com.openappengine.facade.core.widget.context.WidgetProcessorContext;
import com.openappengine.facade.entity.EntityValue;

/**
 * @author hrishikesh.joshi
 * @since  Feb 7, 2012
 *
 */
public abstract class AbstractXmlBackingBeanWidgetProcessor implements WidgetProcessor {
	
	private WidgetProcessorContext context;

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		if(context == null) {
			throw new IllegalArgumentException("WidgetProcessorContext cannot be null.");
		}
		this.context = context;
	}

	//TODO - To be removed.
	@Override
	public Class<?> getWidgetProcessorContextClass() {
		return context.getClass();
	}

	@Override
	public Object processWidget() {
		EntityValue ev = (EntityValue) context.getELContext().getVariable(context.getWidgetBackingObjectValueRef());
		if(ev != null) {
			//TODO - Previous instance for restoring fields in case of binding errors.
			Object previousInstance = ev.getInstance();
			
			//TODO Bind the Servlet Request to XML. Handle Binding Errors.
			
			//TODO Validate and Handle errors.
			
			//TODO - Set submitted widget instance in EV.
			
			//TODO - Call Action Handler.
			
			
			
		}
		return null;
	}
	

}