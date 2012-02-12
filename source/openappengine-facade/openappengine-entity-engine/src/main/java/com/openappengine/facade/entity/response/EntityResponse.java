/**
 * 
 */
package com.openappengine.facade.entity.response;

import org.w3c.dom.Document;

/**
 * Wrapper for all the Responses sent from the Entity Engine.
 * 
 * @author hrishi
 * since Feb 11, 2012
 */
public interface EntityResponse {
	
	Document getEntityResponseDocument();
	
}
