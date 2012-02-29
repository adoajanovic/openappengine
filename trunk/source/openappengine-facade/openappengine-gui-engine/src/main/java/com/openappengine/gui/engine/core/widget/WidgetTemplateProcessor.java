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
	
	public Document processWidgetTemplate(Element widgetEle,GuiEngineContext context) {
		EntityEngineFacade entityEngineFacade = EntityEngineFacadeContext.getEntityFacade();
		String entityName = widgetEle.getAttribute("name");
		String widgetId = widgetEle.getAttribute("id");
		
		Document dataXmlDoc = getInputEntityXml(entityEngineFacade, entityName,widgetId);
		
		List<Element> widgetControlElements = DomUtils.getChildElements(widgetEle);
		
		Document widgetXmlDoc = UtilXml.makeEmptyXmlDocument("widget");
		
		if(widgetControlElements != null) {
			for (Element inputWidgetElement : widgetControlElements) {
				String widgetControlName = inputWidgetElement.getNodeName();
				WidgetMetadata widgetMetadata = widgetMetadataFactory.getWidgetMetadata(widgetControlName);
				Element widgetChildEle = encodeWidget(widgetXmlDoc,inputWidgetElement,widgetMetadata,dataXmlDoc.getDocumentElement());
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
	 * @param inputWidgetEle
	 * @param widgetMetadata 
	 * @return
	 */
	private Element encodeWidget(Document widgetXmlDoc, Element inputWidgetEle, WidgetMetadata widgetMetadata,Node dataNode) {
		String widgetName = widgetMetadata.getWidgetName();				
		Element widgetEle = widgetXmlDoc.createElement(widgetName);
		
		List<WidgetParameter> widgetParameters = widgetMetadata.getWidgetParameters();
		for (WidgetParameter widgetParameter : widgetParameters) {
			String attributeName = widgetParameter.getName();
			String attributeValue = inputWidgetEle.getAttribute(attributeName);
			if(widgetParameter.isMandatory() && StringUtils.isEmpty(attributeValue)) {
				throw new IllegalArgumentException("Attribute " + attributeName + " cannot be empty.");
			}
			
			if(StringUtils.equals(attributeName,"path")) {
				if(StringUtils.equals("node", widgetMetadata.getNodeType())) {
					Node node = UtilXml.evaluateXPathNode(dataNode, attributeValue);
					if(node == null && widgetParameter.isMandatory()) {
						throw new IllegalArgumentException("XPath : " + attributeValue + " incorrectly configured.");
					}
					widgetEle.setTextContent("text");
					//widgetEle.setNodeValue(node.getNodeValue());
				} else if(StringUtils.equals("list", widgetMetadata.getNodeType())) {
					NodeList nodeList = UtilXml.evaluateXPathNodeList(dataNode, attributeValue);
					if(nodeList == null && widgetParameter.isMandatory()) {
						throw new IllegalArgumentException("XPath : " + attributeValue + " incorrectly configured.");
					}
					
					for (int i = 0 ; i < nodeList.getLength(); i++) {
						//TODO
						Node node = nodeList.item(i);
						if(node instanceof Element) {
							doEncodeChildWidgets(widgetXmlDoc, inputWidgetEle,widgetMetadata, node, widgetEle);
						}
					}
				}
				
			}
			
			widgetEle.setAttribute(attributeName, attributeValue);
			
		}
		
		if(widgetMetadata.hasChildren() && !StringUtils.equals("list", widgetMetadata.getNodeType())) {
			doEncodeChildWidgets(widgetXmlDoc, inputWidgetEle,
					widgetMetadata, dataNode, widgetEle);
		}
		
		return widgetEle;
	}

	/**
	 * @param widgetXmlDoc
	 * @param inputWidgetEle
	 * @param widgetMetadata
	 * @param dataNode
	 * @param widgetEle
	 */
	private void doEncodeChildWidgets(Document widgetXmlDoc,
			Element inputWidgetEle, WidgetMetadata widgetMetadata,
			Node dataNode, Element widgetEle) {
		widgetEle.setAttribute("rendersChildren", "true");
		
		List<Element> childElements = DomUtils.getChildElements(inputWidgetEle);
		for (Element childElement : childElements) {
			String childNodeName = childElement.getNodeName();
			WidgetMetadata childWidgetMetadata = widgetMetadata.getChildWidgetsByName(childNodeName);
			if(childWidgetMetadata == null) {
				//TODO
				childWidgetMetadata = widgetMetadataFactory.getWidgetMetadata(childNodeName);
			}
			Element childEle = encodeWidget(widgetXmlDoc, childElement,childWidgetMetadata,dataNode);
			widgetEle.appendChild(childEle);
			widgetXmlDoc.getDocumentElement().appendChild(widgetEle);
		}
	}
}
