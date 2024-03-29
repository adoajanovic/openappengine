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
		List<Element> widgetControlElements = DomUtils.getChildElements(widgetEle);
		
		Document widgetXmlDoc = UtilXml.makeEmptyXmlDocument("widget");
		
		//Metadata
		Element metadataEle = widgetXmlDoc.createElement("metadata");
		metadataEle.setAttribute("rendersChildren", "true");
		widgetXmlDoc.getDocumentElement().appendChild(metadataEle);
		
		
		Element widgetIdMetaEle = widgetXmlDoc.createElement("widgetId");
		widgetIdMetaEle.appendChild(widgetXmlDoc.createTextNode(widgetEle.getAttribute("id")));
		metadataEle.appendChild(widgetIdMetaEle);
		
		if(widgetControlElements != null) {
			for (Element inputWidgetElement : widgetControlElements) {
				String widgetControlName = inputWidgetElement.getNodeName();
				if(StringUtils.equals(widgetControlName, "pre-action") || StringUtils.equals(widgetControlName, "action")) {
					continue;
				}
				WidgetMetadata widgetMetadata = widgetMetadataFactory.getWidgetMetadata(widgetControlName);
				Element widgetChildEle = encodeWidget(widgetXmlDoc,inputWidgetElement,widgetMetadata);
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
	 * @param inputWidgetEle
	 * @param widgetMetadata 
	 * @return
	 */
	private Element encodeWidget(Document widgetXmlDoc, Element inputWidgetEle, WidgetMetadata widgetMetadata) {
		String widgetName = widgetMetadata.getWidgetName();				
		Element widgetEle = widgetXmlDoc.createElement(widgetName);
		
		List<WidgetParameter> widgetParameters = widgetMetadata.getWidgetParameters();
		for (WidgetParameter widgetParameter : widgetParameters) {
			String attributeName = widgetParameter.getName();
			String attributeValue = inputWidgetEle.getAttribute(attributeName);
			if(widgetParameter.isMandatory() && StringUtils.isEmpty(attributeValue)) {
				throw new IllegalArgumentException("Attribute " + attributeName + " cannot be empty.");
			}
			
			widgetEle.setAttribute(attributeName, attributeValue);
			
		}
		
		if(widgetMetadata.hasChildren()) {
			doEncodeChildWidgets(widgetXmlDoc, inputWidgetEle,
					widgetMetadata, widgetEle);
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
			Element widgetEle) {
		widgetEle.setAttribute("rendersChildren", "true");
		
		List<Element> childElements = DomUtils.getChildElements(inputWidgetEle);
		for (Element childElement : childElements) {
			String childNodeName = childElement.getNodeName();
			WidgetMetadata childWidgetMetadata = widgetMetadata.getChildWidgetsByName(childNodeName);
			if(childWidgetMetadata == null) {
				//TODO
				childWidgetMetadata = widgetMetadataFactory.getWidgetMetadata(childNodeName);
			}
			Element childEle = encodeWidget(widgetXmlDoc, childElement,childWidgetMetadata);
			widgetEle.appendChild(childEle);
			widgetXmlDoc.getDocumentElement().appendChild(widgetEle);
		}
	}
}
