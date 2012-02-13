package com.openappengine.gui.engine.core.widget;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.AbstractGuiComponent;

public abstract class AbstractWidget extends AbstractGuiComponent implements Widget {

	private static final long serialVersionUID = 1L;
	
	private String valueRef;
	
	private Document document;
	
	private String transition;
	
	@Override
	public Document getValue() {
		return formBackingObject();
	}

	@Override
	public String getComponentType() {
		return "forms";
	}
	
	@Override
	public Document formBackingObject() {
		return document;
	}
	
	@Override
	public String getComponentName() {
		return "form";
	}
	
	public void setValue(Document doc) {
		this.document = doc;
	}
	
	public String getValueRef() {
		return valueRef;
	}

	public void setValueRef(String entityValueRef) {
		this.valueRef = entityValueRef;
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
}
