/**
 * 
 */
package com.openappengine.gui.engine.core.widget.control;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.reflections.Reflections;
import org.springframework.core.annotation.AnnotationUtils;

import com.openappengine.gui.engine.context.factory.Callback;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetControlRendererFactoryInitializer implements Callback<Map<String,WidgetControlRenderer>>{
	
	private String packageToScan  = "com.openappengine.gui.engine.core.widget.control.custom";

	@Override
	public Map<String, WidgetControlRenderer> onCallback() {
		Reflections reflections = new Reflections(packageToScan);
		Set<Class<? extends WidgetControlRenderer>> widgetControlRenderers = reflections
				.getSubTypesOf(WidgetControlRenderer.class);
		
		Map<String, WidgetControlRenderer> map = new HashMap<String, WidgetControlRenderer>();
		
		if(widgetControlRenderers != null) {
			
			
			for (Class<? extends WidgetControlRenderer> clazz : widgetControlRenderers) {
				if(Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers())) {
					continue;
				}
				
				Control control = AnnotationUtils.findAnnotation(clazz, Control.class);
				if(control == null) {
					continue;
				}
				
				String widgetControlName = control.widgetControlName();
				if(StringUtils.isEmpty(widgetControlName)) {
					throw new IllegalArgumentException("widgetControlName cannot be empty for WidgetControl " + clazz.getName());
				}
				
				try {
					WidgetControlRenderer widgetControlRenderer = clazz.newInstance();
					map.put(widgetControlName, widgetControlRenderer);
				} catch (InstantiationException e) {
					throw new RuntimeException("WidgetControlRenderer " + clazz.getName() + " cannot be instantiated.");
				} catch (IllegalAccessException e) {
					throw new RuntimeException("WidgetControlRenderer " + clazz.getName() + " has been illegally accessed.");
				}
			}
		}
		
		return map;
	}

}
