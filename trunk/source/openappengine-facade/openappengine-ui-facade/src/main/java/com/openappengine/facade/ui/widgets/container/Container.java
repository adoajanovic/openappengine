/**
 * 
 */
package com.openappengine.facade.ui.widgets.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.ui.widgets.Widget;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Container implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;

	private List<Widget> widgets = new ArrayList<Widget>();

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
	
	public void addWidget(Widget widget) {
		if(widget == null) {
			return;
		}
		this.widgets.add(widget);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
