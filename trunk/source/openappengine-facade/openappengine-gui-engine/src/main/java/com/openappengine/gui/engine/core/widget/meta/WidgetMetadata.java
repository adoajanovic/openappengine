/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import java.util.List;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public interface WidgetMetadata {
	
	List<WidgetParameter> getWidgetParameters();

	String getWidgetName();
	
	List<WidgetMetadata> getChildWidgetsMetadata();
	
	WidgetMetadata getChildWidgetsByName(String name);
	
	boolean hasChildren();
}
