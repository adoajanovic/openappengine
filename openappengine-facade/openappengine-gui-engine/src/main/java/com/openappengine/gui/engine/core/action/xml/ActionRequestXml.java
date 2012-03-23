/**
 * 
 */
package com.openappengine.gui.engine.core.action.xml;

import org.w3c.dom.Document;


/**
 * @author hrishi
 * since Feb 10, 2012
 */
public interface ActionRequestXml {
	
	Document getActionRequestXmlDocument();
	
	String getActionName();
}
