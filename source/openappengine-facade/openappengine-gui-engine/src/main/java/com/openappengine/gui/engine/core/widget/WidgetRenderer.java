/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.entity.definition.Entity;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.meta.WidgetContext;
import com.openappengine.gui.engine.core.widget.meta.WidgetMetadata;
import com.openappengine.gui.engine.core.widget.meta.WidgetMetadataFactory;
import com.openappengine.gui.engine.core.widget.meta.WidgetParameter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetRenderer {
	
	private static final Logger logger = Logger.getLogger(WidgetRenderer.class);
	
	private WidgetMetadataFactory widgetMetadataFactory = WidgetContext.getWidgetMetadataFactory();
	
	public Document renderWidget(Element widgetEle,GuiEngineContext context) {
		EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
		String entityName = widgetEle.getAttribute("name");
		String widgetId = widgetEle.getAttribute("id");
		
		Entity entityDefinition = entityEngineFacade.findEntityDefinition(entityName);
		if (entityDefinition == null) {
			throw new IllegalStateException("Entity " + entityName + " not found for Widget : [id:"
					+ widgetId + "].");
		}
		Document doc = entityDefinition.getDocument();
		
		List<Element> widgetControlElements = DomUtils.getChildElements(widgetEle);
		
		Document widgetXmlDoc = UtilXml.makeEmptyXmlDocument("widget");
		if(widgetControlElements != null) {
			for (Element widgetControlEle : widgetControlElements) {
				String widgetControlName = widgetControlEle.getNodeName();
				WidgetMetadata widgetMetadata = widgetMetadataFactory.getWidgetMetadata(widgetControlName);
				Element widgetChildEle = encodeWidget(widgetXmlDoc,widgetControlEle,widgetMetadata,doc);
				widgetXmlDoc.getDocumentElement().appendChild(widgetChildEle);
			}
		}
		
		if(logger.isTraceEnabled()) {
			String xmlStr = UtilXml.writeXmlDocument(widgetXmlDoc);
			logger.trace(xmlStr);
		}
		return widgetXmlDoc;
	}

	/**
	 * @param widgetXmlDoc
	 * @param widgetControlEle
	 * @param widgetMetadata 
	 * @return
	 */
	private Element encodeWidget(Document widgetXmlDoc, Element widgetControlEle, WidgetMetadata widgetMetadata,Document entityDoc) {
		String widgetName = widgetMetadata.getWidgetName();				
		Element widgetEle = widgetXmlDoc.createElement(widgetName);
		
		List<WidgetParameter> widgetParameters = widgetMetadata.getWidgetParameters();
		for (WidgetParameter widgetParameter : widgetParameters) {
			
			String attribute = widgetControlEle.getAttribute(widgetParameter.getName());
			if(widgetParameter.isMandatory() && StringUtils.isEmpty(attribute)) {
				throw new IllegalArgumentException("Attribute " + widgetParameter.getName() + " cannot be empty.");
			}
			
			if(StringUtils.equals(widgetParameter.getName(),"path")) {
				Node node = UtilXml.evaluateXPathExpression(entityDoc, attribute);
				if(node == null) {
					throw new IllegalArgumentException("XPath : " + attribute + " incorrectly configured.");
				}
				
				widgetEle.setNodeValue(node.getNodeValue());
			}
			
			widgetEle.setAttribute(widgetParameter.getName(), attribute);
			
		}
		
		if(widgetMetadata.hasChildren()) {
			List<Element> childElements = DomUtils.getChildElements(widgetControlEle);
			for (Element childElement : childElements) {
				WidgetMetadata childWidgetMetadata = widgetMetadata.getChildWidgetsByName(childElement.getNodeName());
				Element childEle = encodeWidget(widgetXmlDoc, childElement,childWidgetMetadata,entityDoc);
				widgetEle.appendChild(childEle);
				widgetXmlDoc.getDocumentElement().appendChild(widgetEle);
			}
		}
		
		return widgetEle;
	}
}
