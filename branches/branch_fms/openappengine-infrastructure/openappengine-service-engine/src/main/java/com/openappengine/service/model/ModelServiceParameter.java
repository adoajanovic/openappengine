/**
 * 
 */
package com.openappengine.service.model;

/**
 * {@link ModelServiceParameter} represents the parameters that are used
 * to call the {@link ModelService}.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ModelServiceParameter {
	
	private String name;
	
	private Class<?> type;
	
	private String mode;
	
	private Boolean optional;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

}
