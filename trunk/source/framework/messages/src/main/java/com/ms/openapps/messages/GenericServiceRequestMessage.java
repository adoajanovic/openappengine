/**
 * 
 */
package com.ms.openapps.messages;

/**
 * @author hrishi
 *
 */
public class GenericServiceRequestMessage extends GenericServiceMessage {
	
	private static final long serialVersionUID = 1L;
	
	private RequestPayload requestPayload;

	public RequestPayload getRequestPayload() {
		return new RequestPayload();
	}

	public void setRequestPayload(RequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}

}
