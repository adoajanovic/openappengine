package com.openappengine.gui.engine.context.factory;

import org.springframework.core.io.Resource;
import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Dec 28, 2011
 */
public interface GuiDefinitionReader {
	
	Document getScreenXmlDocument(Resource resource);
	
}
