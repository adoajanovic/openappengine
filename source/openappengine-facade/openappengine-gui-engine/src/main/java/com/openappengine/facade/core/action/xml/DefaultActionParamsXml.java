/**
 * 
 */
package com.openappengine.facade.core.action.xml;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 11, 2012
 */
public class DefaultActionParamsXml implements ActionParamsXml {
	
	private Document document;

	/**
	 * @param document
	 */
	public DefaultActionParamsXml(Document document) {
		this.document = document;
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

	public String getActionName() {
		String actionName = document.getDocumentElement().getAttribute("action-name");
		return actionName;
	}

}
