/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor.factory;

import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.openappengine.facade.core.component.widget.processor.WidgetProcessor;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class WidgetProcessorFactory {
	
	private static Map<String,WidgetProcessor> widgetProcessorMap = new ConcurrentHashMap<String, WidgetProcessor>();
	
	protected static final Logger logger = Logger.getLogger(WidgetProcessorFactory.class); 
	
	static {
		Set<Class<? extends WidgetProcessor>> processors = new WidgetProcessorFactoryInitializer().initializeWidgetProcessorFactory();
		if(processors != null) {
			for (Class<? extends WidgetProcessor> clazz : processors) {
				try {
					if(!Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
						WidgetProcessor widgetProcessor = clazz.newInstance();
						widgetProcessorMap.put(widgetProcessor.getProcessedWidgetType(), widgetProcessor);
					}
				} catch (Exception e) {
					logger.error("Cannot Initialize WidgetProcessorFactory.",e);
					throw new RuntimeException("Cannot Initialize WidgetProcessorFactory");
				}
			}
		}
	}

	public WidgetProcessor getWidgetProcessor(String widgetType) {
		if(StringUtils.isEmpty(widgetType)) {
			return null;
		}
		return widgetProcessorMap.get(widgetType);
	}
	
}
