/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.util.ArrayList;
import java.util.List;


/**
 * @author hrishikesh.joshi
 * @since  Feb 13, 2012
 *
 */
public class FormListWidget extends AbstractWidget {

	private static final long serialVersionUID = 1L;
	
	private List<FormField> fields = new ArrayList<FormField>();
	
	@Override
	public String getWidgetType() {
		return "form-list";
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
	
	public boolean isAutoEntity() {
		if(getFields() == null || getFields().isEmpty()) {
			return true;
		}
		
		return false;
	}

}
