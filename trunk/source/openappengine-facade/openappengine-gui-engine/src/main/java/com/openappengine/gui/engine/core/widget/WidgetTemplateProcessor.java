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
public class WidgetTemplateProcessor {
	
	private static final Logger logger = Logger.getLogger(WidgetTemplateProcessor.class);
	
	private WidgetMetadataFactory widgetMetadataFactory = WidgetContext.getWidgetMetadataFactory();
	
	public Document renderWidget(Element widgetEle,GuiEngineContext context) {
		EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
		String entityName = widgetEle.getAttribute("name");
		String widgetId = widgetEle.getAttribute("id");
		
		Document doc = getInputEntityXml(entityEngineFacade, entityName,widgetId);
		
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
		return doc;
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
			String attributeName = widgetParameter.getName();
			String attributeValue = widgetControlEle.getAttribute(attributeName);
			if(widgetParameter.isMandatory() && StringUtils.isEmpty(attributeValue)) {
				throw new IllegalArgumentException("Attribute " + attributeName + " cannot be empty.");
			}
			
			if(StringUtils.equals(attributeName,"path")) {
				Node node = UtilXml.evaluateXPathExpression(entityDoc, attributeValue);
				if(node == null) {
					throw new IllegalArgumentException("XPath : " + attributeValue + " incorrectly configured.");
				}
				
				widgetEle.setNodeValue(node.getNodeValue());
			}
			
			widgetEle.setAttribute(attributeName, attributeValue);
			
		}
		
		if(widgetMetadata.hasChildren()) {
			widgetEle.setAttribute("rendersChildren", "true");
			
			List<Element> childElements = DomUtils.getChildElements(widgetControlEle);
			for (Element childElement : childElements) {
				WidgetMetadata childWidgetMetadata = widgetMetadata.getChildWidgetsByName(childElement.getNodeName());
				if(childWidgetMetadata == null) {
					//TODO
				}
				Element childEle = encodeWidget(widgetXmlDoc, childElement,childWidgetMetadata,entityDoc);
				widgetEle.appendChild(childEle);
				widgetXmlDoc.getDocumentElement().appendChild(widgetEle);
			}
		}
		
		return widgetEle;
	}
}
