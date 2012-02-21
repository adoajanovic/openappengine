/**
 * 
 */
package com.openappengine.gui.engine.core.transformer.widget;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
import com.openappengine.gui.engine.core.transformer.Transformer;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.core.xml.transformer.StringConverter;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public abstract class WidgetTypeTransformer<T extends Widget> implements Transformer<Document, Document> {
	
	private T widget;
	
	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
		// TODO Auto-generated method stub
	}
	
	protected abstract boolean supportsWidget(Widget widget);
	
	protected abstract Document transformWidget(T widget,Document responseXml);
	
	@Override
	public Document transform(Document responseXml) {
		if(widget == null) {
			throw new IllegalStateException("Widget Not Set..Cannot transform Widget.");
		}
		if(supportsWidget(widget)) {
			Document transformedWidgetXml = transformWidget(widget, responseXml);
			return transformedWidgetXml;
		}
		return null;
	}

	public void setWidget(T widget) {
		this.widget = widget;
	}

}
