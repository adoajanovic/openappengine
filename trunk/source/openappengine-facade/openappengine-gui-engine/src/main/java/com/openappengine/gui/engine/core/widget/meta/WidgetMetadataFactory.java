/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public interface WidgetMetadataFactory {
	
	void registerWidget(WidgetMetadata widgetMetadata);
	
	WidgetMetadata getWidgetMetadata(String name);
	
}
