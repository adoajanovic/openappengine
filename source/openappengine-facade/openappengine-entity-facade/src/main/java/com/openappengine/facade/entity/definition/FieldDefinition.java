/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.Serializable;

/**
 * @author hrishikesh.joshi
 *
 */
public class FieldDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	private String property;
	
	private boolean pk;
	
	private boolean updatable;
	
	private boolean required;
	
	private UIDescriptor uiDescriptor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public boolean isPk() {
		return pk;
	}

	public void setPk(boolean pk) {
		this.pk = pk;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public UIDescriptor getUiDescriptor() {
		return uiDescriptor;
	}

	public void setUiDescriptor(UIDescriptor uiDescriptor) {
		this.uiDescriptor = uiDescriptor;
	}
	
}
