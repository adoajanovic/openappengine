/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.widget.control.WidgetControl;


/**
 * @author hrishikesh.joshi
 * @since  Feb 13, 2012
 *
 */
public class FormListWidget extends AbstractWidget {

	private static final long serialVersionUID = 1L;
	
	private List<WidgetControl> fields = new ArrayList<WidgetControl>();
	
	@Override
	public String getWidgetType() {
		return "form-list";
	}

	public List<WidgetControl> getFields() {
		return fields;
	}

	public void setFields(List<WidgetControl> fields) {
		this.fields = fields;
	}
	
	public void addField(WidgetControl widgetControl) {
		if(widgetControl == null) {
			return;
		}
		fields.add(widgetControl);
	}
	
	public boolean isAutoEntity() {
		if(getFields() == null || getFields().isEmpty()) {
			return true;
		}
		
		return false;
	}

}
