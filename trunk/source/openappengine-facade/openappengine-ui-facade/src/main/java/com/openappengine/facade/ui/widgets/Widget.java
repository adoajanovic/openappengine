/**
 * 
 */
package com.openappengine.facade.ui.widgets;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Widget implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String type;
	
	//TODO - Add base properties to this class.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
