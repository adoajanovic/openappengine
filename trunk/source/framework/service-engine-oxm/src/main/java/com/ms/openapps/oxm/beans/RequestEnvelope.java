/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.io.Serializable;

/**
 * @author h.shrikant.joshi
 *
 */
public class RequestEnvelope implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Request MetaData*/
	private RequestMetaData requestMetaData;
	
	/* Request Payload*/
	private RequestPayload requestPayload;

	public RequestPayload getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(RequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}

	public RequestMetaData getRequestMetaData() {
		return requestMetaData;
	}

	public void setRequestMetaData(RequestMetaData requestMetaData) {
		this.requestMetaData = requestMetaData;
	}

}
