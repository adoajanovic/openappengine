/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.io.Serializable;

/**
 * @author h.shrikant.joshi
 *
 */
public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PayloadData payloadData;

	public PayloadData getPayloadData() {
		return payloadData;
	}

	public void setPayloadData(PayloadData payloadData) {
		this.payloadData = payloadData;
	}

}
