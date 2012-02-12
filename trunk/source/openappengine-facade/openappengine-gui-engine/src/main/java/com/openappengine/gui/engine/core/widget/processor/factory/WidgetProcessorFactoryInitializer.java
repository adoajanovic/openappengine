/**
 * 
 */
package com.openappengine.gui.engine.core.widget.processor.factory;

import java.util.Set;

import org.reflections.Reflections;

import com.openappengine.gui.engine.core.widget.processor.WidgetProcessor;

/**
 * @author hrishikesh.joshi
 * @since  Jan 30, 2012
 *
 */
public class WidgetProcessorFactoryInitializer {
	
	private String packageToScan = "com.openappengine.gui.engine.core.widget.processor";
	
	public Set<Class<? extends WidgetProcessor>> initializeWidgetProcessorFactory() {
		Reflections reflections = new Reflections(getPackageToScan());
		Set<Class<? extends WidgetProcessor>> widgetProcessors = reflections.getSubTypesOf(WidgetProcessor.class);
		return widgetProcessors;
	}

	/**
	 * @return the packageToScan
	 */
	public String getPackageToScan() {
		return packageToScan;
	}

	/**
	 * @param packageToScan the packageToScan to set
	 */
	public void setPackageToScan(String packageToScan) {
		this.packageToScan = packageToScan;
	}

}
