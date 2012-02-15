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
					doProcessFormField(formDoc, rootFieldEle, fieldEle);
				}
			}
		} else {
			List<FormField> formFields = formSingleWidget.getFields();
			for (FormField formField : formFields) {
				for (Element fieldEle : fields) {
					String fieldName = fieldEle.getAttribute("name");
					if(StringUtils.equals(formField.getEntryName(), fieldName)) {
						doProcessFormField(formDoc, documentElement, fieldEle);
					}
				}
			}
		}
		String xmlDocumentString = 
				"<form>" +
				"<fieldGroup header=\"Personal Information\">" +
					"<label>First Name</label>" +	
					"<input name=\"First Name\" type=\"\"/>" +
					"<label>Last Name</label>" +
					"<input name=\"Last Name\" type=\"\"/>" +
					"<label>Age</label>" +
					"<input name=\"Age\" type=\"\"/>" +
					"<label>Gender</label>" +
					"<input name=\"Gender\" type=\"\"/>" +
					"<label>DOB</label>" +
					"<input name=\"Date Of Birth\" type=\"\"/>" +
				"</fieldGroup>" +
				"<fieldGroup header=\"Address Information\">" +
					"<label>Add 1</label>" +
					"<input name=\"Address1\" type=\"\"/>" +
					"<label>Add 2</label>" +
					"<input name=\"Address2\" type=\"\"/>" +
					"<label>City</label>" +
					"<input name=\"City\" type=\"\"/>" +
					"<label>State</label>" +
					"<input name=\"State\" type=\"\"/>" +
					"<label>Country</label>" +
					"<input name=\"Country\" type=\"\"/>" +
					"<label>Zip</label>" +					
					"<input name=\"Zip\" type=\"\"/>" +
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
	private void doProcessFormField(Document formDoc, Element documentElement,
			Element fieldEle) {
		Element formFieldEle = formDoc.createElement("field");
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
