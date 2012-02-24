/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.widget.control.SelectOption;

/**
 * @author hrishikesh.joshi
 * @since  Feb 24, 2012
 *
 */
public class SelectOptionParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		SelectOption selectOption = new SelectOption();
		String attrId = element.getAttribute("id");
		String attrLabel = element.getAttribute("label");
		String attrValue = element.getAttribute("value");
		selectOption.setLabel(attrLabel);
		selectOption.setValue(attrValue);
		selectOption.setId(attrId);
		return selectOption;
	}

	@Override
	public String getParsedNodeName() {
		return "select-option";
	}

}
