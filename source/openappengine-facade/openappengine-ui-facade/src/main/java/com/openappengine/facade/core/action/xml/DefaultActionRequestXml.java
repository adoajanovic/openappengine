/**
 * 
 */
package com.openappengine.facade.core.action.xml;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public class DefaultActionRequestXml implements ActionRequestXml {
	
	private Document document;
	
	public DefaultActionRequestXml(Document document) {
		if(document == null) {
			throw new IllegalArgumentException("Exception creating the Action Request XML. Document found null.!");
		}
		this.document = document;
	}

	@Override
	public Document getActionRequestXmlDocument() {
		return document;
	}

}
