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
import org.w3c.dom.NodeList;

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
		
		Document dataXmlDoc = getInputEntityXml(entityEngineFacade, entityName,widgetId);
		
		List<Element> widgetControlElements = DomUtils.getChildElements(widgetEle);
		
		Document widgetXmlDoc = UtilXml.makeEmptyXmlDocument("widget");
		
		if(widgetControlElements != null) {
			for (Element widgetControlEle : widgetControlElements) {
				String widgetControlName = widgetControlEle.getNodeName();
				WidgetMetadata widgetMetadata = widgetMetadataFactory.getWidgetMetadata(widgetControlName);
				Element widgetChildEle = encodeWidget(widgetXmlDoc,widgetControlEle,widgetMetadata,dataXmlDoc);
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
				if(StringUtils.equals("node", widgetMetadata.getNodeType())) {
					Node node = UtilXml.evaluateXPathNode(entityDoc, attributeValue);
					if(node == null) {
						throw new IllegalArgumentException("XPath : " + attributeValue + " incorrectly configured.");
					}
					widgetEle.setNodeValue(node.getNodeValue());
				} else if(StringUtils.equals("list", widgetMetadata.getNodeType())) {
					NodeList nodeList = UtilXml.evaluateXPathNodeList(entityDoc, attributeValue);
					if(nodeList == null) {
						throw new IllegalArgumentException("XPath : " + attributeValue + " incorrectly configured.");
					}
					
					/*if(!widgetMetadata.hasChildren()) {
						throw new IllegalArgumentException("Expected children for this widget.");
					}*/
					for (int i = 0 ; i < nodeList.getLength(); i++) {
						//TODO
						doEncodeChildWidgets(widgetXmlDoc, widgetControlEle,widgetMetadata, entityDoc, widgetEle);
					}
				}
				
			}
			
			widgetEle.setAttribute(attributeName, attributeValue);
			
		}
		
		if(widgetMetadata.hasChildren()) {
			doEncodeChildWidgets(widgetXmlDoc, widgetControlEle,
					widgetMetadata, entityDoc, widgetEle);
		}
		
		return widgetEle;
	}

	/**
	 * @param widgetXmlDoc
	 * @param widgetControlEle
	 * @param widgetMetadata
	 * @param entityDoc
	 * @param widgetEle
	 */
	private void doEncodeChildWidgets(Document widgetXmlDoc,
			Element widgetControlEle, WidgetMetadata widgetMetadata,
			Document entityDoc, Element widgetEle) {
		widgetEle.setAttribute("rendersChildren", "true");
		
		List<Element> childElements = DomUtils.getChildElements(widgetControlEle);
		for (Element childElement : childElements) {
			String childNodeName = childElement.getNodeName();
			WidgetMetadata childWidgetMetadata = widgetMetadata.getChildWidgetsByName(childNodeName);
			if(childWidgetMetadata == null) {
				//TODO
				childWidgetMetadata = widgetMetadataFactory.getWidgetMetadata(childNodeName);
			}
			Element childEle = encodeWidget(widgetXmlDoc, childElement,childWidgetMetadata,entityDoc);
			widgetEle.appendChild(childEle);
			widgetXmlDoc.getDocumentElement().appendChild(widgetEle);
		}
	}
}
