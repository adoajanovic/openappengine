/**
 * 
 */
package com.ms.openapps.oxm.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author h.shrikant.joshi
 *
 */
public class RequestMetaData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date requestedTimeStamp;

	public Date getRequestedTimeStamp() {
		return requestedTimeStamp;
	}

	public void setRequestedTimeStamp(Date requestedTimeStamp) {
		this.requestedTimeStamp = requestedTimeStamp;
	}

}
