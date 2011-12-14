/**
 * 
 */
package com.openappengine.web.render;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * @author hrishikesh.joshi
 *
 */
public class RenderMode implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final String READ_ONLY = "RO";
	
	public static final String READ_WRITE = "RW";
	
	private String currentMode = READ_WRITE;
	
	public RenderMode() {
	}
	
	public RenderMode(String renderMode) {
		this.setCurrentMode(renderMode);
	}

	public String getCurrentMode() {
		return currentMode;
	}

	protected void setCurrentMode(String currentMode) {
		this.currentMode = currentMode;
	}
	
	public void changeMode(String newMode) {
		this.currentMode = newMode;
	}
	
	public void changeToReadWriteMode() {
		this.currentMode = READ_WRITE;
	}
	
	public void changeToReadOnlyMode() {
		this.currentMode = READ_ONLY;
	}
	
	public boolean isReadOnlyMode() {
	    return StringUtils.equals(currentMode, READ_ONLY);
	}
	
	public boolean isReadWriteMode() {
	    return StringUtils.equals(currentMode, READ_WRITE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentMode == null) ? 0 : currentMode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RenderMode other = (RenderMode) obj;
		if (currentMode == null) {
			if (other.currentMode != null)
				return false;
		} else if (!currentMode.equals(other.currentMode))
			return false; 
		return true;
	}

}
