/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetContext implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}
	
	public static WidgetMetadataFactory getWidgetMetadataFactory() {
		return context.getBean("widgetFactory", WidgetMetadataFactory.class);
	}

}
