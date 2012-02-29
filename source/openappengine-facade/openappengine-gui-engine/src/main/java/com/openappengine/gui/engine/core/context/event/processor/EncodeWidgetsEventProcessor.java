/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.widget.WidgetTemplateProcessor;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Feb 21, 2012
 *
 */
public class EncodeWidgetsEventProcessor implements LifecycleEventProcessor<GuiEngineContext> {

	@Override
	public void onLifecycleEvent(ApplicationEvent<GuiEngineContext> event,GuiEngineContext t) {
		Document screenXmlDocument = t.getScreenXmlDocument();
		Element pageContentEle = DomUtils.getChildElementByTagName(screenXmlDocument.getDocumentElement(), "page-content");
		
		List<Element> widgetElementList = DomUtils.getChildElementsByTagName(pageContentEle, "widget");
		if(widgetElementList != null) {
			for (Element widgetElement : widgetElementList) {
				Document document = encodeWidgetControls(widgetElement, t);
				String attrWidgetId = UtilXml.readElementAttribute(widgetElement, "id");
				t.addWidget(attrWidgetId, document);
			}
		}
	}

	/**
	 * @param element
	 * @param context 
	 */
	protected Document encodeWidgetControls(Element element, GuiEngineContext context) {
		WidgetTemplateProcessor widgetTemplateProcessor = new WidgetTemplateProcessor();
		Document renderedWidgetXml = widgetTemplateProcessor.processWidgetTemplate(element, context);
		return renderedWidgetXml;
	}
	
	/**
	 * @param t
	 * @param widget
	 * @param transformedDocumentXml
	 */
	private void registerWidgetWithModelMap(GuiEngineContext t,
			String attrWidgetId, Document renderedWidgetXml) {
		t.getExternalContext().addModelMapAttribute(attrWidgetId, renderedWidgetXml);
	}

}
