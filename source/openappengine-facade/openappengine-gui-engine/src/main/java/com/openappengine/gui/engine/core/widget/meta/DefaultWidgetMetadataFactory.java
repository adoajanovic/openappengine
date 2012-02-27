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
public class DefaultWidgetMetadataFactory implements WidgetMetadataFactory,Callback<Object> {
	
	private WidgetMetadataConfigurationReader widgetMetadataConfigurationReader;
	
	private Map<String,WidgetMetadata> widgetMetadataMap = new HashMap<String, WidgetMetadata>();
	
	public void initializeDefaultWidgetFactory() {
		widgetMetadataConfigurationReader.readWidgetMetadata(this);
	}
	
	@Override
	public WidgetMetadata getWidgetMetadata(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
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
	public Object onCallback() {
		List<WidgetMetadata> readWidgetMetadata = widgetMetadataConfigurationReader.readWidgetMetadata(this);
		return null;
	}

	@Override
	public void registerWidget(WidgetMetadata widgetMetadata) {
		this.widgetMetadataMap.put(widgetMetadata.getWidgetName(), widgetMetadata);
	}

}
