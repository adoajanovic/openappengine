/**
 * 
 */
package com.openappengine.entity.request;

import org.w3c.dom.Document;

/**
 * @author hrishi
 * since Feb 12, 2012
 */
public interface EntityRequest {
	
	void setRequestXml(Document document);
	
	Document getRequestXml();
	
}
