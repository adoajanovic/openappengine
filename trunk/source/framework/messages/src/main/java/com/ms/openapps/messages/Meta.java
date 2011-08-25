/**
 * 
 */
package com.ms.openapps.messages;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class Meta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String status;

	private int phase;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

}
