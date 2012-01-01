/**
 * 
 */
package com.openappengine.facade.context.factory.xml;

import org.w3c.dom.Document;

import com.openappengine.facade.core.component.ui.GuiRootComponent;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public interface ScreenDefinitionDocumentReader {
	
	
	/**
	 * Read the XML Document and return the UI Root Component.
	 * @param doc
	 * @return
	 */
	GuiRootComponent readUIRootDefinition(Document doc);

}
