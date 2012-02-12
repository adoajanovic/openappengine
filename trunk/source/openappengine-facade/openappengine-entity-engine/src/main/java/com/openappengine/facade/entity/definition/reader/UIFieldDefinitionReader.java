/**
 * 
 */
package com.openappengine.facade.entity.definition.reader;

import org.w3c.dom.Element;

import com.openappengine.facade.entity.definition.ui.UIField;

/**
 * @author hrishi
 *
 */
public interface UIFieldDefinitionReader {
	
	public abstract UIField getUIFieldDefinition(Element fieldElement);

}
