/**
 * 
 */
package com.openappengine.gui.engine.core.transformer;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.transformer.widget.WidgetTypeTransformer;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.core.xml.transformer.StringConverter;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public class WidgetTransformer implements Transformer<ActionResponseXml, Document> {
	
	private static Map<String,WidgetTypeTransformer> widgetTransformers;
	
	private String packageToScan;

	private Widget widget;
	
	static {
		WidgetTypeFactoryInitializer factoryInitializer = new WidgetTypeFactoryInitializer();
		widgetTransformers = factoryInitializer.onCallback();
	}
	
	/**
	 * @param widget
	 */
	public WidgetTransformer(Widget widget) {
		Assert.notNull(widget,"Cannot Transform. Widget found null.");
		this.widget = widget;
	}

	@Override
	public Document transform(ActionResponseXml actionResponseXml) {
		String widgetType = widget.getWidgetType();
		if(StringUtils.isEmpty(widgetType)) {
			//TODO.
			widgetType = "form-single"; 
		}
		
		WidgetTypeTransformer transformer = widgetTransformers.get(widgetType);
		Assert.notNull(transformer,"WidgetTransformer not configured for WidgetType :" + widgetType);
		
		transformer.setWidget(widget);
		return transformer.transform(actionResponseXml);
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
	}

	public String getPackageToScan() {
		return packageToScan;
	}

	public void setPackageToScan(String packageToScan) {
		this.packageToScan = packageToScan;
	}

}
