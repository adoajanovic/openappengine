/**
 * 
 */
package com.openappengine.serviceengine.message;

import java.io.Serializable;

import org.w3c.dom.Document;

/**
 * @author hrishi
 *
 */
public class ServiceResponseMessageWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Document xmlResponse;
	
	public ServiceResponseMessageWrapper(Document xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	public Document getXmlResponse() {
		return xmlResponse;
	}
}
