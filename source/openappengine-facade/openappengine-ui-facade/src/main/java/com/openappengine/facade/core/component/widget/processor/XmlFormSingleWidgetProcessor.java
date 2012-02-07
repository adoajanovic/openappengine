/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;

/**
 * @author hrishikesh.joshi
 * @since  Feb 7, 2012
 *
 */
public class XmlFormSingleWidgetProcessor implements XmlBackingBeanWidgetProcessor {

	/* (non-Javadoc)
	 * @see com.openappengine.facade.core.component.widget.processor.WidgetProcessor#getProcessedWidgetType()
	 */
	@Override
	public String getProcessedWidgetType() {
		return "xml-form-single";
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.core.component.widget.processor.WidgetProcessor#setWidgetProcessorContext(com.openappengine.facade.core.component.widget.context.WidgetProcessorContext)
	 */
	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.core.component.widget.processor.WidgetProcessor#getWidgetProcessorContextClass()
	 */
	@Override
	public Class<?> getWidgetProcessorContextClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.openappengine.facade.core.component.widget.processor.WidgetProcessor#processWidget()
	 */
	@Override
	public Object processWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
