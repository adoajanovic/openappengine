/**
 * 
 */
package com.openappengine.gui.engine.core.widget;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.entity.EntityEngineFacade;
import com.openappengine.entity.context.EntityEngineFacadeContext;
import com.openappengine.entity.definition.Entity;
import com.openappengine.gui.engine.core.context.GuiEngineContext;
import com.openappengine.gui.engine.core.widget.control.DefaultWidgetControlWriter;
import com.openappengine.gui.engine.core.widget.control.WidgetControlRenderer;
import com.openappengine.gui.engine.core.widget.control.WidgetControlRendererFactoryInitializer;
import com.openappengine.gui.engine.core.widget.control.WidgetControlWriter;
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
	
	private static Map<String, WidgetControlRenderer> widgetControlRenderers;
	
	private WidgetMetadataFactory widgetMetadataFactory = WidgetContext.getWidgetMetadataFactory();
	
	static {
		WidgetControlRendererFactoryInitializer initializer = new WidgetControlRendererFactoryInitializer();
		widgetControlRenderers = initializer.onCallback();
	}
	
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
				
				String widgetName = widgetMetadata.getWidgetName();				
				Element widgetChildEle = widgetXmlDoc.createElement(widgetName);
				
				List<WidgetParameter> widgetParameters = widgetMetadata.getWidgetParameters();
				for (WidgetParameter widgetParameter : widgetParameters) {
					String attribute = widgetControlEle.getAttribute(widgetParameter.getName());
					if(widgetParameter.isMandatory() && StringUtils.isEmpty(attribute)) {
						throw new IllegalArgumentException("Attribute " + widgetParameter.getName() + " cannot be empty.");
					}
					
					widgetChildEle.setAttribute(widgetParameter.getName(), attribute);
					
				}
				
				widgetXmlDoc.getDocumentElement().appendChild(widgetChildEle);
				
				//TODO - to be replaced by metadata api.
				/*Element element = encodeWidgetControl(context, doc, widgetXmlDoc.getDocumentElement(), widgetControlEle);
				widgetXmlDoc.getDocumentElement().appendChild(element);*/
			}
		}
		
		if(logger.isTraceEnabled()) {
			String xmlStr = UtilXml.writeXmlDocument(widgetXmlDoc);
			logger.trace(xmlStr);
		}
		return widgetXmlDoc;
	}

	/**
	 * @param context
	 * @param doc
	 * @param xmlDocument
	 * @param widgetControlEle
	 * @return 
	 */
	private Element encodeWidgetControl(GuiEngineContext context,Document doc, Element xmlDocument, Element widgetControlEle) {
		String widgetControlName = widgetControlEle.getNodeName();
		
		String attrPath = widgetControlEle.getAttribute("path");
		if(StringUtils.isNotEmpty(attrPath)) {
			Node node = UtilXml.evaluateXPathExpression(doc, attrPath);
			if(node == null) {
				throw new IllegalStateException("The XPath Location :" + attrPath + " cannot be found.");
			}
		}
		
		WidgetControlRenderer widgetControlRenderer = widgetControlRenderers.get(widgetControlName);
		Assert.notNull(widgetControlRenderer, "No WidgetControlRenderer found for WidgetControl " + widgetControlName);
		
		//Initialize Writer for WidgetControl
		WidgetControlWriter writer = new DefaultWidgetControlWriter(xmlDocument);
		
		widgetControlRenderer.encodeBegin(widgetControlEle, context, writer);
		
		List<Element> childEles = DomUtils.getChildElements(widgetControlEle);
		if(childEles != null && !childEles.isEmpty()) {
		
			Element encodedElement = writer.getWidgetControlElement();
			xmlDocument.getOwnerDocument().getDocumentElement().appendChild(encodedElement);
			
			if(widgetControlRenderer.rendersChildren()) {
				widgetControlRenderer.encodeChildren(widgetControlEle, context, writer);
			} else {
				for (Element element : childEles) {
					Element childControlEle = encodeWidgetControl(context, doc, encodedElement, element);
					encodedElement.appendChild(childControlEle);
				}
			}
			
			
		} else {
			widgetControlRenderer.encodeEnd(widgetControlEle, context, writer);
			
		}
		
		Element element = writer.getWidgetControlElement();
		System.out.println(UtilXml.writeXmlDocument(xmlDocument.getOwnerDocument()));
		return element;
	}

}
