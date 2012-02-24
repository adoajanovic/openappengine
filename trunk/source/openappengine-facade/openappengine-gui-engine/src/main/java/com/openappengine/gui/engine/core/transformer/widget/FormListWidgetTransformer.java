/**
 * 
 */
package com.openappengine.gui.engine.core.transformer.widget;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.widget.FormListWidget;
import com.openappengine.gui.engine.core.widget.Widget;
import com.openappengine.gui.engine.core.widget.annotation.WidgetType;
import com.openappengine.gui.engine.core.widget.control.WidgetControl;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Feb 13, 2012
 *
 */
@WidgetType("form-list")
public class FormListWidgetTransformer extends WidgetTypeTransformer<FormListWidget> {

	@Override
	protected boolean supportsWidget(Widget widget) {
		return FormListWidget.class.isAssignableFrom(widget.getClass());
	}

	@Override
	protected Document transformWidget(FormListWidget widget, Document responseXml) {
		if(responseXml == null) {
			return null;
		}
		
		return translateFormList(responseXml.getDocumentElement(), widget);
	}
	
	/**
	 * @param element
	 * @param formSingleWidget TODO
	 */
	private Document translateFormList(Element element, FormListWidget formListWidget) {
		Document formDoc = UtilXml.makeEmptyXmlDocument(formListWidget.getComponentName());
		Element documentElement = formDoc.getDocumentElement();
		List<Element> fields = DomUtils.getChildElementsByTagName(element, "field");
		
		if(formListWidget.isAutoEntity()) {
			if(fields != null) {
				for (Element fieldEle : fields) {
					doProcessFormField(formDoc, documentElement, fieldEle);
				}
			}
		} else {
			List<WidgetControl> widgetControls = formListWidget.getFields();
			for (WidgetControl widgetControl : widgetControls) {
				for (Element fieldEle : fields) {
					Element formFieldEle = formDoc.createElement("formfield");
					String fieldName = fieldEle.getAttribute("name");
					if(StringUtils.equals(widgetControl.getPath(), fieldName)) {
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

}
