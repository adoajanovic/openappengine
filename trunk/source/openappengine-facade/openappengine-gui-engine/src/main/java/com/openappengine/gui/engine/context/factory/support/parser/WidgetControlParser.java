/**
 * 
 */
package com.openappengine.gui.engine.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.openappengine.gui.engine.core.component.GuiComponent;
import com.openappengine.gui.engine.core.widget.control.SelectOption;
import com.openappengine.gui.engine.core.widget.control.WidgetControl;

/**
 * @author hrishi
 * since Feb 5, 2012
 */
public class WidgetControlParser extends AbstractGuiElementDefinitionParser {

	@Override
	public GuiComponent parse(Element element) {
		
		WidgetControl widgetControl = new WidgetControl();
		
		String attrType = element.getAttribute("type");
		if(StringUtils.isEmpty(attrType)) {
			attrType = "textfield";
		}
		
		String attrPath = element.getAttribute("path");
		if(StringUtils.isEmpty(attrPath)) {
			throw new XmlDefinitionParserException("[Element :" + getParsedNodeName() + "] attribute [entry-name] cannot be empty.");
		}
		widgetControl.setPath(attrPath);
		
		String attrHidden = element.getAttribute("hidden");
		boolean hidden = false;
		if(!StringUtils.isEmpty(attrHidden)) {
			hidden = Boolean.parseBoolean(attrHidden);
		}
		widgetControl.setHidden(hidden);
		
		String attrValueRef = element.getAttribute("value-ref");
		if(StringUtils.isNotEmpty(attrValueRef)) {
			widgetControl.setValueRef(attrValueRef);
		}
		
		widgetControl.setType(attrType);
		
		if (StringUtils.equals(attrType, "dropdown")
			 || StringUtils.equals(attrType, "radio")) {
			parseOptionElement(element, widgetControl);
		}
		
		return widgetControl;
	}

	/**
	 * @param element
	 * @param widgetControl TODO
	 */
	private void parseOptionElement(Element element, WidgetControl widgetControl) {
		NodeList nodeList = element.getChildNodes();
		if(nodeList != null) {
			for(int i=0; i < nodeList.getLength(); i++) {
				Node optionNode = nodeList.item(i);
				if(optionNode.getNodeName().equals("select-option")) {
					GuiElementDefinitionParser parser = getDelegate().getScreenElementDefinitionParser(optionNode.getNodeName());
					SelectOption selectOption = (SelectOption) parser.parse((Element) optionNode);
					widgetControl.getSelectOptions().add(selectOption);
				}	
			}
		}
	}

	@Override
	public String getParsedNodeName() {
		return "widget-control";
	}
	

}
