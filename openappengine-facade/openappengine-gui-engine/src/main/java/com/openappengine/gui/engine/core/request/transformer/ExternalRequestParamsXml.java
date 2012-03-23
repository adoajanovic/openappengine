/**
 * 
 */
package com.openappengine.gui.engine.core.request.transformer;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 11, 2012
 */
public class ExternalRequestParamsXml {
	
	private Document document;

	/**
	 * @param document
	 */
	public ExternalRequestParamsXml(Document document) {
		super();
		this.document = document;
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

}
