/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetMetadataImpl implements WidgetMetadata {
	
	private String widgetName;
	
	private List<WidgetParameter> widgetParameters = new ArrayList<WidgetParameter>();
	
	private List<WidgetMetadata> childWidgetsMetadata = new ArrayList<WidgetMetadata>();
	
	private Map<String, WidgetMetadata> childWidgetMetadataMap = new HashMap<String, WidgetMetadata>();

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

	public List<WidgetMetadata> getChildWidgetsMetadata() {
		return childWidgetsMetadata;
	}

	public void setChildWidgetsMetadata(List<WidgetMetadata> childWidgetsMetadata) {
		this.childWidgetsMetadata = childWidgetsMetadata;
		
		for (WidgetMetadata widgetMetadata : childWidgetsMetadata) {
			childWidgetMetadataMap.put(widgetMetadata.getWidgetName(), widgetMetadata);
		}
		
	}

	@Override
	public boolean hasChildren() {
		return childWidgetsMetadata != null && !childWidgetsMetadata.isEmpty();
	}

	@Override
	public WidgetMetadata getChildWidgetsByName(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		
		return childWidgetMetadataMap.get(name);
	}

}
