/**
 * 
 */
package com.openappengine.gui.engine.core.transformer.widget;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

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
		Document formDoc = UtilXml.makeEmptyXmlDocument(formSingleWidget.getComponentName());
		Element documentElement = formDoc.getDocumentElement();
		
		Element rootFieldEle = formDoc.createElement("field");
		rootFieldEle.setAttribute("type", "complex");
		
		documentElement.appendChild(rootFieldEle);
		
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		
		if(formSingleWidget.isAutoEntity()) {
			if(fields != null) {
				for (Element fieldEle : fields) {
					doProcessAutoFormControl(formDoc, rootFieldEle, fieldEle);
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
		String xmlDocumentString = 
				"<form>" +
					"<fieldGroup header=\"Personal Information\">" +
						"<label>Hrishi</label>" +
						"<label>Inside FG Inside Row</label>" +
					"</fieldGroup>" +
				"</form>";
		try {
			System.out.println(xmlDocumentString);
			return UtilXml.readXmlDocument(xmlDocumentString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(xmlDocumentString);
		return formDoc;
	}

	/**
	 * @param formDoc
	 * @param documentElement
	 * @param fieldEle
	 */
	private void doProcessAutoFormControl(Document formDoc, Element documentElement,
			Element fieldEle) {
		Element formControlEle = formDoc.createElement("control");
		String fieldName = fieldEle.getAttribute("name");
		formControlEle.setAttribute("name", fieldName);
		formControlEle.setAttribute("type", fieldEle.getAttribute("type"));
		formControlEle.setTextContent(fieldEle.getTextContent());
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
