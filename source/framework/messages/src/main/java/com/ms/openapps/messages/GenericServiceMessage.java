/**
 * 
 */
package com.ms.openapps.messages;

import java.io.Serializable;

/**
 * @author hrishi
 * 
 */
public class GenericServiceMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Meta meta;

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}
