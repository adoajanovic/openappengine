/**
 * 
 */
package com.openappengine.gui.engine.core.action.xml;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 11, 2012
 */
public class SimpleActionResponseXml implements ActionResponseXml {
	
	private Document responseDocument;
	
	/**
	 * @param document
	 */
	public SimpleActionResponseXml(Document doc) {
		this.responseDocument = doc;
	}

	@Override
	public Document getResponseDocument() {
		return responseDocument;
	}
	
}
