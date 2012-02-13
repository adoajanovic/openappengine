/**
 * 
 */
package com.openappengine.gui.engine.core.transformer.widget;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.action.xml.ActionResponseXml;
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

	/**
	 * @param element
	 * @param formSingleWidget TODO
	 */
	private Document translateFormSingle(Element element, FormSingleWidget formSingleWidget) {
		Document formDoc = UtilXml.makeEmptyXmlDocument("form");
		Element documentElement = formDoc.getDocumentElement();
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		
		if(formSingleWidget.isAutoEntity()) {
			if(fields != null) {
				for (Element fieldEle : fields) {
					doProcessFormField(formDoc, documentElement, fieldEle);
				}
			}
		} else {
			List<FormField> formFields = formSingleWidget.getFields();
			for (FormField formField : formFields) {
				for (Element fieldEle : fields) {
					Element formFieldEle = formDoc.createElement("formfield");
					String fieldName = fieldEle.getAttribute("name");
					if(StringUtils.equals(formField.getEntryName(), fieldName)) {
						doProcessFormField(formDoc, documentElement, fieldEle);
					}
				}
			}
		}
		return formDoc;
	}

	/**
	 * @param formDoc
	 * @param documentElement
	 * @param fieldEle
	 */
	private void doProcessFormField(Document formDoc, Element documentElement,
			Element fieldEle) {
		Element formFieldEle = formDoc.createElement("formfield");
		String fieldName = fieldEle.getAttribute("name");
		formFieldEle.setAttribute("name", fieldName);
		formFieldEle.setAttribute("type", fieldEle.getAttribute("type"));
		formFieldEle.setTextContent(fieldEle.getTextContent());
		documentElement.appendChild(formFieldEle);
	}
	
	@Override
	protected boolean supportsWidget(Widget widget) {
		return FormSingleWidget.class.isAssignableFrom(widget.getClass());
	}

	@Override
	protected Document transformWidget(FormSingleWidget widget,ActionResponseXml responseXml) {
		Document responseDocument = responseXml.getResponseDocument();
		List<Element> entityElements = DomUtils.getChildElementsByTagName(responseDocument.getDocumentElement(), "entity");
		
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
