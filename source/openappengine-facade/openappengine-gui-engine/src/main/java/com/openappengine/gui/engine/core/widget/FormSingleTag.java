package com.openappengine.gui.engine.core.widget;

import org.w3c.dom.Document;



/**
 * 
 * FormSingleTag
 * 
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public class FormSingleTag extends AbstractBackingBeanWidgetComponent {

	private static final long serialVersionUID = 1L;
	
	private String transition;
	
	@Override
	public String getComponentName() {
		return "form";
	}

	@Override
	public String getWidgetType() {
		return "form-single";
	}
	
	/**
	 * @return the transition
	 */
	public String getTransition() {
		return transition;
	}

	/**
	 * @param transition the transition to set
	 */
	public void setTransition(String transition) {
		this.transition = transition;
	}

	@Override
	public String getValueRef() {
		return getEntityValueRef();
	}

	@Override
	public Document getValue() {
		return formBackingObject();
	}
	
}
