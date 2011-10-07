/**
 * 
 */
package com.openappengine.bpm.procmod;

import java.io.Serializable;

import org.w3c.dom.Document;

/**
 * @author hrishi
 *
 */
public class DataModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Data Payload of the Request 
	 */
	private Document data;
	
	/**
	 * 	The XML Namespace.
	 */
	private String xmlns;

	public Document getData() {
		return data;
	}

	public void setData(Document data) {
		this.data = data;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

}
