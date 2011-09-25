/**
 * 
 */
package com.openappengine.bpm.model;

import java.io.Serializable;

import org.w3c.dom.Document;

/**
 * @author hrishi
 *
 */
public class DataModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/* Data */
	private Document data;

	public Document getData() {
		return data;
	}

	public void setData(Document data) {
		this.data = data;
	}

}
