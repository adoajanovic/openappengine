/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.List;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.api.ValueEntity;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
import com.openappengine.gui.engine.core.widget.WidgetTemplateProcessor;

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
				EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
				String entityName = widgetElement.getAttribute("name");
				String widgetId = widgetElement.getAttribute("id");
				
				ValueEntity valueEntity = entityEngineFacade.makeValueEntity(entityName);
				if(valueEntity == null) {
					throw new IllegalArgumentException("ValueEntity not found for Entity Name : " + entityName);
				}
				
				Document widgetTemplateXml = encodeWidgetControls(widgetElement, t);
				WidgetTemplateNode node = new WidgetTemplateNode(widgetId,widgetTemplateXml,valueEntity);
				t.addWidget(widgetId, node);
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

}
