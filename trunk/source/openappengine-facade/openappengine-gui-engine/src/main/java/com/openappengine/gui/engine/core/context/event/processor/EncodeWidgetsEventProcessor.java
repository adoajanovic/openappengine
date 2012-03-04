/**
 * 
 */
package com.openappengine.gui.engine.core.context.event.processor;

import java.util.List;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.entity.definition.Entity;
import com.openappengine.gui.engine.core.context.ApplicationEvent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.context.LifecycleEventProcessor;
import com.openappengine.gui.engine.core.widget.WidgetTemplateNode;
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
				
				EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
				String entityName = widgetElement.getAttribute("name");
				String widgetId = widgetElement.getAttribute("id");
				Document widgetDataXml = getInputEntityXml(entityEngineFacade, entityName,widgetId);
				Document widgetTemplateXml = encodeWidgetControls(widgetElement, t);
				WidgetTemplateNode node = new WidgetTemplateNode(widgetId, widgetTemplateXml, widgetDataXml);
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
	
	/**
	 * @param entityEngineFacade
	 * @param entityName
	 * @param widgetId
	 * @return
	 */
	private Document getInputEntityXml(EntityEngineFacade entityEngineFacade,
			String entityName, String widgetId) {
		Entity entityDefinition = entityEngineFacade.findEntityDefinition(entityName);
		if (entityDefinition == null) {
			throw new IllegalStateException("Entity " + entityName + " not found for Widget : [id:"
					+ widgetId + "].");
		}
		Document doc = entityDefinition.getDocument();
		UtilXml.writeXmlDocument(doc);
		String xmlAsStr = "<Entity>" + 
						"<User><username type=\"String\">hrishi2323</username><password type=\"Password\">sumedh</password><firstName type=\"String\">Hrishikesh</firstName>" +
						"<lastName type=\"String\">Joshi</lastName><comments type=\"String\">Hi.....</comments><date type=\"Date\">03/15/2012</date>" +
						"<active type=\"Boolean\">true</active><currency type=\"String\">USD</currency></User>";
						if(!widgetId.equals("gridEx")) {
							xmlAsStr +=
							"<User><username type=\"String\">hrishi23231</username><password type=\"Password\">sumedh1</password><firstName type=\"String\">Hrishikesh</firstName>" +
							"<lastName type=\"String\">Joshi</lastName><comments type=\"String\">Hi.....</comments><date type=\"Date\">03/15/2012</date>" +
							"<active type=\"Boolean\">true</active><currency type=\"String\">USD</currency></User>" +									
							"<User><username type=\"String\">hrishi23232</username><password type=\"Password\">sumedh2</password><firstName type=\"String\">Hrishikesh</firstName>" +
							"<lastName type=\"String\">Joshi</lastName><comments type=\"String\">Hi.....</comments><date type=\"Date\">03/15/2012</date>" +
							"<active type=\"Boolean\">true</active><currency type=\"String\">USD</currency></User>" + 
							"<User><username type=\"String\">hrishi23233</username><password type=\"Password\">sumedh3</password><firstName type=\"String\">Hrishikesh</firstName>" +
							"<lastName type=\"String\">Joshi</lastName><comments type=\"String\">Hi.....</comments><date type=\"Date\">03/15/2012</date>" +
							"<active type=\"Boolean\">true</active><currency type=\"String\">USD</currency></User>";
						}
						
						xmlAsStr += "</Entity>";
		try {
			doc = UtilXml.readXmlDocument(xmlAsStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return doc;
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
