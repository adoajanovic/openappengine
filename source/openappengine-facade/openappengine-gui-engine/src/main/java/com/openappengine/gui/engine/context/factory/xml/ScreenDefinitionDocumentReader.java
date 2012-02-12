/**
 * 
 */
package com.openappengine.gui.engine.context.factory.xml;

import org.w3c.dom.Document;

import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;

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
