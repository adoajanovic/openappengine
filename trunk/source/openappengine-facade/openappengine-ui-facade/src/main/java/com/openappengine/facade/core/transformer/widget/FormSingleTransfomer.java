/**
 * 
 */
package com.openappengine.facade.core.transformer.widget;

import java.util.List;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.facade.core.action.xml.ActionResponseXml;
import com.openappengine.facade.core.widget.annotation.WidgetType;
import com.openappengine.facade.core.xml.transformer.StringConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
@WidgetType("form-single")
public class FormSingleTransfomer extends WidgetTypeTransformer{

	@Override
	public Document transform(ActionResponseXml responseXml) {
		Document responseDocument = responseXml.getResponseDocument();
		List<Element> entityElements = DomUtils.getChildElementsByTagName(responseDocument.getDocumentElement(), "entity");
		
		if(entityElements != null) {
			for (Element element : entityElements) {
				Document formSingleDoc = translateFormSingle(element);
				return formSingleDoc;
			}
		}
		
		return null;
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
	}

	/**
	 * @param element
	 */
	private Document translateFormSingle(Element element) {
		Document formDoc = UtilXml.makeEmptyXmlDocument("form");
		Element documentElement = formDoc.getDocumentElement();
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		if(fields != null) {
			for (Element fieldEle : fields) {
				Element formFieldEle = formDoc.createElement("formfield");
				
				String fieldName = fieldEle.getAttribute("name");
				formFieldEle.setAttribute("name", fieldName);
				formFieldEle.setAttribute("type", fieldEle.getAttribute("type"));
				formFieldEle.setTextContent(fieldEle.getTextContent());
				
				documentElement.appendChild(formFieldEle);
			}
		}
		return formDoc;
	}
	
}
