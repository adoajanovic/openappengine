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
public class ServiceRequestMessageWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Document xmlRequest;

	public ServiceRequestMessageWrapper(Document xmlRequest) {
		this.xmlRequest = xmlRequest;
	}

	public Document getXmlRequest() {
		return xmlRequest;
	}
	
}
