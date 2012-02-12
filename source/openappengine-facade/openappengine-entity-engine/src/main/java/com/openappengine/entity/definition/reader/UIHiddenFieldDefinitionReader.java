/**
 * 
 */
package com.openappengine.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.entity.definition.ui.UIField;
import com.openappengine.entity.definition.ui.UIHiddenField;

/**
 * @author hrishi
 *
 */
public class UIHiddenFieldDefinitionReader implements UIFieldDefinitionReader {

	@Override
	public UIField getUIFieldDefinition(Element fieldElement) {
		return new UIHiddenField();
	}
}
