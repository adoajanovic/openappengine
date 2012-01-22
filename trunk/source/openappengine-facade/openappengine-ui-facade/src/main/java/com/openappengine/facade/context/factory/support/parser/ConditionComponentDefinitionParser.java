/**
 * 
 */
package com.openappengine.facade.context.factory.support.parser;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Element;

import com.openappengine.facade.core.component.GuiComponent;
import com.openappengine.facade.core.component.condition.ConditionComponent;

/**
 * @author hrishi
 * since Jan 22, 2012
 */
public class ConditionComponentDefinitionParser extends AbstractGuiElementDefinitionParser {

	private static final long serialVersionUID = 1L;

	@Override
	public GuiComponent parse(Element element) {
		ConditionComponent conditionComponent = new ConditionComponent();
		String condition = element.getTextContent();
		if(StringUtils.isEmpty(condition)) {
			condition = "true";
		}
		conditionComponent.setCondition(condition);
		return conditionComponent;
	}

	@Override
	public String getParsedNodeName() {
		return "condition";
	}

}
