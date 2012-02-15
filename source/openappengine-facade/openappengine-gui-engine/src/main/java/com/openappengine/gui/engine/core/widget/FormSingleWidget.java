package com.openappengine.gui.engine.core.widget;

import java.util.ArrayList;
import java.util.List;




/**
 * 
 * FormSingleWidget
 * 
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public class FormSingleWidget extends AbstractWidget {

	private static final long serialVersionUID = 1L;
	
	private List<FormField> fields = new ArrayList<FormField>();
	
	@Override
	public String getWidgetType() {
		return "form-single";
	}
	
	public boolean isAutoEntity() {
		if(getFields() == null || getFields().isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public List<FormField> getFields() {
		return fields;
	}

	public void setFields(List<FormField> fields) {
		this.fields = fields;
	}
	
	public void addField(FormField formField) {
		if(formField == null) {
			return;
		}
		fields.add(formField);
	}
}