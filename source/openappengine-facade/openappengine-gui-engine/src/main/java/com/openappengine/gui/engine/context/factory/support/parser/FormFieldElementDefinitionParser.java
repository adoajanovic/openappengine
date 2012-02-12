/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.widget.FormFieldComponent;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class FormFieldElementDefinitionParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		FormFieldComponent formFieldComponent = new FormFieldComponent();
		String attrEntryName = element.getAttribute("entry-name");
		if(StringUtils.isEmpty(attrEntryName)) {
			throw new XmlDefinitionParserException("[Element :" + getParsedNodeName() + "] attribute [entry-name] cannot be empty.");
		}
		formFieldComponent.setEntryName(attrEntryName);
		
		String attrHidden = element.getAttribute("hidden");
		boolean hidden = false;
		if(!StringUtils.isEmpty(attrHidden)) {
			hidden = Boolean.parseBoolean(attrHidden);
		}
		
		String attrValueRef = element.getAttribute("value-ref");
		if(StringUtils.isNotEmpty(attrValueRef)) {
			formFieldComponent.setValueRef(attrValueRef);
		}
		
		formFieldComponent.setHidden(hidden);
		return formFieldComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "form-field";
	}

}
