/**
 * 
 */
package com.openappengine.facade.core.transformer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import com.openappengine.facade.context.factory.Callback;
import com.openappengine.facade.core.transformer.widget.WidgetTypeTransformer;
import com.openappengine.facade.core.widget.annotation.WidgetType;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public class WidgetTypeFactoryInitializer implements Callback<Map<String,WidgetTypeTransformer>>{
	
	private String packageToScan = "com.openappengine.facade.core.transformer.widget";

	public WidgetTypeFactoryInitializer() {
		super();
	}

	@Override
	public Map<String, WidgetTypeTransformer> onCallback() {
		Reflections reflections = new Reflections(getPackageToScan());
		Set<Class<? extends WidgetTypeTransformer>> widgetTypeTransfomers = reflections
				.getSubTypesOf(WidgetTypeTransformer.class);
		
		Map<String, WidgetTypeTransformer> widgetTypeTransformerMap = new HashMap<String, WidgetTypeTransformer>();
		
		if(widgetTypeTransfomers != null) {
			for (Class<? extends WidgetTypeTransformer> transformer : widgetTypeTransfomers) {
				WidgetType widgetType = AnnotationUtils.findAnnotation(transformer, WidgetType.class);
				try {
					widgetTypeTransformerMap.put(widgetType.value(), transformer.newInstance());
				} catch (InstantiationException e) {
					throw new RuntimeException("Exception Creating WidgetTypeTransfomer " + transformer.getName());
				} catch (IllegalAccessException e) {
					throw new RuntimeException("Exception Creating WidgetTypeTransfomer " + transformer.getName());
				}
			}
		}
		return widgetTypeTransformerMap;
	}

	protected String getPackageToScan() {
		return packageToScan;
	}

	public void setPackageToScan(String packageToScan) {
		this.packageToScan = packageToScan;
	}

}
