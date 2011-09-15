/**
 * 
 */
package com.openappengine.container;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 *
 */
public class Component implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String componentName;
	
	private String componentLocation;

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getComponentLocation() {
		return componentLocation;
	}

	public void setComponentLocation(String componentLocation) {
		this.componentLocation = componentLocation;
	}
}
