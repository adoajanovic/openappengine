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

import com.openappengine.gui.engine.core.widget.FormField;
import com.openappengine.gui.engine.core.widget.FormSingleWidget;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.core.widget.annotation.WidgetType;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
@WidgetType("form-single")
public class FormSingleTransfomer extends WidgetTypeTransformer<FormSingleWidget>{

	protected static final Logger logger = Logger.getLogger(FormSingleTransfomer.class);
			
	/**
	 * @param element
	 * @param formSingleWidget TODO
	 */
	private Document translateFormSingle(Element element, FormSingleWidget formSingleWidget) {
		String entityName = element.getAttribute("name");
		
		Document formDoc = UtilXml.makeEmptyXmlDocument(formSingleWidget.getComponentName());
		Element documentElement = formDoc.getDocumentElement();
		documentElement.setAttribute("name", entityName);
		documentElement.setAttribute("id", formSingleWidget.getId());
		
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		
		
		if(formSingleWidget.isAutoEntity()) {
			if(fields != null) {
				for (Element fieldEle : fields) {
					doProcessAutoFormControl(formDoc, documentElement, fieldEle);
				}
			}
		} else {
			//TODO - Handle this..Using the XPATH exprssion.
			List<FormField> formFields = formSingleWidget.getFields();
			for (FormField formField : formFields) {
				for (Element fieldEle : fields) {
					String fieldName = fieldEle.getAttribute("name");
					if(StringUtils.equals(formField.getEntryName(), fieldName)) {
						doProcessAutoFormControl(formDoc, documentElement, fieldEle);
					}
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
			fieldType = "text";
			if(fieldEle.getAttribute("length") != null) {
				Integer length = UtilXml.readIntegerElementAttribute(fieldEle, "length");
				if(length != null && length >= 500) {
					fieldType = "textarea";
				}
			}
		} else if (StringUtils.equals(type, "Boolean")) {
			fieldType = "radio";
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
		return FormSingleWidget.class.isAssignableFrom(widget.getClass());
	}

	@Override
	protected Document transformWidget(FormSingleWidget widget,Document responseXml) {
		List<Element> entityElements = DomUtils.getChildElementsByTagName(responseXml.getDocumentElement(), "entity");
		
		if(entityElements != null) {
			if(entityElements.size() != 1) {
				throw new IllegalStateException(
						"More than one <entity> found in response. Cannot Transform Response to Widget XML.");
			}
			
			Document formSingleDoc = translateFormSingle(entityElements.get(0), widget);
			return formSingleDoc;
		}
		
		return null;
	}
	
}
