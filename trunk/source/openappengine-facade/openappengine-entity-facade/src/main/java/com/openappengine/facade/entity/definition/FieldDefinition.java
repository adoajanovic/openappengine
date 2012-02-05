/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.Serializable;

import com.openappengine.facade.entity.definition.ui.UIField;

/**
 * @author hrishikesh.joshi
 *
 */
public class FieldDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	private String property;
	
	private boolean pk;
	
	private boolean autoincrement;
	
	private boolean updatable;
	
	private boolean required;
	
	private boolean numeric;
	
	private boolean alpha;
	
	private boolean alphanumeric;
	
	//TODO
	private boolean hidden;
	
	private UIField uiField;

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

	public UIField getUiField() {
	    return uiField;
	}

	public void setUiField(UIField uiField) {
	    this.uiField = uiField;
	}

	public boolean isAutoincrement() {
	    return autoincrement;
	}

	public void setAutoincrement(boolean autoincrement) {
	    this.autoincrement = autoincrement;
	}

	public boolean isNumeric() {
		return numeric;
	}

	public void setNumeric(boolean numeric) {
		this.numeric = numeric;
	}

	public boolean isAlpha() {
		return alpha;
	}

	public void setAlpha(boolean alpha) {
		this.alpha = alpha;
	}

	public boolean isAlphanumeric() {
		return alphanumeric;
	}

	public void setAlphanumeric(boolean alphanumeric) {
		this.alphanumeric = alphanumeric;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}
