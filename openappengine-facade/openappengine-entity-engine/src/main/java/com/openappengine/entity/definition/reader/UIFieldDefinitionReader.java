/**
 * 
 */
package com.openappengine.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.entity.definition.ui.UIField;

/**
 * @author hrishi
 *
 */
public interface UIFieldDefinitionReader {
	
	public abstract UIField getUIFieldDefinition(Element fieldElement);

}
