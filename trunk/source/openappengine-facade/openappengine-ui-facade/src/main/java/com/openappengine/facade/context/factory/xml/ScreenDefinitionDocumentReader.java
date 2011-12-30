/**
 * 
 */
package com.openappengine.facade.context.factory.xml;

import org.w3c.dom.Document;

/**
 * @author hrishikesh.joshi
 * @since Dec 30, 2011
 */
public interface ScreenDefinitionDocumentReader {
	
	
	void registerScreenDefinition(Document doc,ScreenReaderContext readerContext);

}
