/**
 * 
 */
package com.openappengine.facade.ui.widgets;

import java.io.Serializable;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class Widget implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Screen parentScreen;

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

	public Screen getParentScreen() {
		return parentScreen;
	}

	public void setParentScreen(Screen parentScreen) {
		this.parentScreen = parentScreen;
	}
}
