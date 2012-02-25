/**
 * 
 */
package com.openappengine.gui.engine.core.transformer.widget;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.gui.engine.core.widget.DefaultWidget;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.core.widget.annotation.WidgetType;
import com.openappengine.gui.engine.core.widget.control.SelectOption;
import com.openappengine.gui.engine.core.widget.control.WidgetControl;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
@WidgetType("widget")
public class DefaultWidgetTransfomer extends WidgetTypeTransformer<DefaultWidget>{

	protected static final Logger logger = Logger.getLogger(DefaultWidgetTransfomer.class);
			
	/**
	 * @param element
	 * @param defaultWidget TODO
	 */
	private Document translateFormSingle(Element element, DefaultWidget defaultWidget) {
		String entityName = element.getNodeName();
		
		Document formDoc = UtilXml.makeEmptyXmlDocument(defaultWidget.getComponentName());
		Element documentElement = formDoc.getDocumentElement();
		documentElement.setAttribute("name", entityName);
		documentElement.setAttribute("id", defaultWidget.getId());
		
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		
		
		if(defaultWidget.isAutoEntity()) {
			if(fields != null) {
				for (Element fieldEle : fields) {
					doProcessAutoFormControl(formDoc, documentElement, fieldEle);
				}
			}
		} else {
			//TODO - Handle this..Using the XPATH exprssion.
			List<WidgetControl> widgetControls = defaultWidget.getWidgetControls();
			for (WidgetControl widgetControl : widgetControls) {
				String path = widgetControl.getPath();
				String type = widgetControl.getType();
				
				Node node = UtilXml.evaluateXPathExpression(element.getOwnerDocument(), path);
				if(node == null) {
					throw new IllegalStateException("The WidgetControl : "
							+ widgetControl.getId()
							+ " is incorrectly mapped for Entity :"
							+ entityName);
				}
				
				if(node instanceof Element) {
					Element fieldEle = (Element) node;
					Element formControlEle = formDoc.createElement("control");
					
					String fieldName = fieldEle.getNodeName();
					
					//Standard Attributes
					formControlEle.setAttribute("name", path);
					formControlEle.setAttribute("id", fieldName + "_id");
					formControlEle.setAttribute("labelId", entityName + "." + fieldName);
					formControlEle.setAttribute("type", type);
					formControlEle.setNodeValue(fieldEle.getNodeValue());
					
					if(widgetControl.hasSelectOptions()) {
						List<SelectOption> selectOptions = widgetControl.getSelectOptions();
						for (SelectOption selectOption : selectOptions) {
							Element optionEle = formDoc.createElement("option");
							optionEle.setAttribute("label", selectOption.getLabel());
							optionEle.setAttribute("id", selectOption.getId());
							
							String selectOptionXpath = selectOption.getPath();
							if(StringUtils.isNotEmpty(selectOptionXpath)) {
								Node corrEntityNode = UtilXml.evaluateXPathExpression(element.getOwnerDocument(), selectOptionXpath);
								if(corrEntityNode == null) {
									throw new IllegalStateException("The WidgetControl : "
											+ selectOption.getId()
											+ " is incorrectly mapped for Entity :"
											+ entityName);
								}
								
								String nodeValue = corrEntityNode.getNodeValue();
								optionEle.setAttribute("value", nodeValue);
							} else {
								optionEle.setAttribute("value", selectOption.getValue());
							}
							
							formControlEle.appendChild(optionEle);
							formDoc.getDocumentElement().appendChild(formControlEle);
						}
					}
					
					formDoc.getDocumentElement().appendChild(formControlEle);
				}
			}
		}
		String xmlDocument = UtilXml.writeXmlDocument(formDoc);
		logger.info("Widget XML Generated :\n" + xmlDocument);
		
		return formDoc;
	}

	/**
	 * @param formDoc
	 * @param documentElement
	 * @param fieldEle
	 */
	private void doProcessAutoFormControl(Document formDoc, Element documentElement,
			Element fieldEle) {
		
		String entityName = documentElement.getAttribute("name");
		String fieldName = fieldEle.getAttribute("name");
		
		Element formControlEle = formDoc.createElement("control");
		
		//Standard Attributes
		formControlEle.setAttribute("name", fieldName);
		formControlEle.setAttribute("id", fieldName + "_id");
		formControlEle.setAttribute("labelId", entityName + "." + fieldName);
		
		//Field Type
		String type = fieldEle.getAttribute("type");
		if(StringUtils.isEmpty(type)) {
			type = "String";
		}
		
		String fieldType = "";
		if (!StringUtils.equals(type, "Boolean")
				&& !StringUtils.equals(type, "Date")
				&& !StringUtils.equals(type, "DateTime")
				&& !StringUtils.equals(type, "DateTime")
				&& !StringUtils.equals(type, "Password")) {
			fieldType = "textfield";
			if(fieldEle.getAttribute("length") != null) {
				Integer length = UtilXml.readIntegerElementAttribute(fieldEle, "length");
				if(length != null && length >= 500) {
					fieldType = "textarea";
				}
			}
		} else if (StringUtils.equals(type, "Boolean")) {
			fieldType = "checkbox";
		} else if (StringUtils.equals(type, "Date")) {
			fieldType = "date";
		} else if (StringUtils.equals(type, "Password")) {
			fieldType = "password";
		}
		
		formControlEle.setAttribute("type", fieldType);
		//Optional Attributes
		
		//Access Key
		if(StringUtils.isNotEmpty(fieldEle.getAttribute("accesskey"))) {
			formControlEle.setAttribute("accesskey", fieldEle.getAttribute("accesskey"));
		}
		String textContent = fieldEle.getTextContent();
		if(textContent != null) {
			textContent = textContent.trim();
		}
		
		//Value
		formControlEle.setTextContent(textContent);
		documentElement.appendChild(formControlEle);
	}
	
	@Override
	protected boolean supportsWidget(Widget widget) {
		return DefaultWidget.class.isAssignableFrom(widget.getClass());
	}

	@Override
	protected Document transformWidget(DefaultWidget widget,Document responseXml) {
		System.out.println(UtilXml.writeXmlDocument(responseXml));
		/*if(entityElements.size() != 1) {
		List<Element> entityElements = DomUtils.getChildElementsByTagName(responseXml.getDocumentElement(), "entity");
		if(entityElements != null) {
				throw new IllegalStateException(
						"More than one <entity> found in response. Cannot Transform Response to Widget XML.");
		}
		*/
		Document formSingleDoc = translateFormSingle(responseXml.getDocumentElement(), widget);
		return formSingleDoc;
	}
	
}
