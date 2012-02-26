/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.gui.engine.context.factory.Callback;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class DefaultWidgetMetadataFactory implements WidgetMetadataFactory,Callback<Map<String,WidgetMetadata>> {
	
	private WidgetMetadataConfigurationReader widgetMetadataConfigurationReader;
	
	private Map<String,WidgetMetadata> widgetMetadataMap;
	
	@Override
	public WidgetMetadata getWidgetMetadata(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		
		if(widgetMetadataMap == null) {
			widgetMetadataMap = this.onCallback();
		}
		
		if(widgetMetadataMap != null) {
			return widgetMetadataMap.get(name);
		}
		return null;
	}

	public WidgetMetadataConfigurationReader getWidgetMetadataConfigurationReader() {
		return widgetMetadataConfigurationReader;
	}

	public void setWidgetMetadataConfigurationReader(WidgetMetadataConfigurationReader widgetMetadataConfigurationReader) {
		this.widgetMetadataConfigurationReader = widgetMetadataConfigurationReader;
	}

	@Override
	public Map<String,WidgetMetadata> onCallback() {
		List<WidgetMetadata> readWidgetMetadata = widgetMetadataConfigurationReader.readWidgetMetadata();
		Map<String,WidgetMetadata> map = new HashMap<String, WidgetMetadata>();
		if(readWidgetMetadata != null) {
			for (WidgetMetadata widgetMetadata : readWidgetMetadata) {
				map.put(widgetMetadata.getWidgetName(), widgetMetadata);
			}
		}
		return map;
	}

	public Map<String,WidgetMetadata> getWidgetMetadataMap() {
		return widgetMetadataMap;
	}

	public void setWidgetMetadataMap(Map<String,WidgetMetadata> widgetMetadataMap) {
		this.widgetMetadataMap = widgetMetadataMap;
	}

}
