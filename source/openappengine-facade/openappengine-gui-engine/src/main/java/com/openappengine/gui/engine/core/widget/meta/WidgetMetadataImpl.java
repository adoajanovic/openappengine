/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetMetadataImpl implements WidgetMetadata {
	
	private String widgetName;
	
	private List<WidgetParameter> widgetParameters = new ArrayList<WidgetParameter>();

	@Override
	public List<WidgetParameter> getWidgetParameters() {
		return widgetParameters;
	}

	public void setWidgetParameters(List<WidgetParameter> widgetParameters) {
		this.widgetParameters = widgetParameters;
	}

	@Override
	public String getWidgetName() {
		return widgetName;
	}

	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}

}
