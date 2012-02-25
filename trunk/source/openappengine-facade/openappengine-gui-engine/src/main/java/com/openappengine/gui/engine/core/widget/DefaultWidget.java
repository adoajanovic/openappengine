package com.openappengine.gui.engine.core.widget;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.gui.engine.core.widget.control.WidgetControl;




/**
 * 
 * DefaultWidget
 * 
 * @author hrishikesh.joshi
 * @since  Feb 1, 2012
 *
 */
public class DefaultWidget extends AbstractWidget {

	private static final long serialVersionUID = 1L;
	
	private List<WidgetControl> widgetControls = new ArrayList<WidgetControl>();
	
	@Override
	public String getWidgetType() {
		return "widget";
	}
	
	public boolean isAutoEntity() {
		if(getWidgetControls() == null || getWidgetControls().isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public List<WidgetControl> getWidgetControls() {
		return widgetControls;
	}

	public void setWidgetControls(List<WidgetControl> fields) {
		this.widgetControls = fields;
	}
	
	public void addField(WidgetControl widgetControl) {
		if(widgetControl == null) {
			return;
		}
		widgetControls.add(widgetControl);
	}
}
