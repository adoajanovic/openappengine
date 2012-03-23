/**
 * 
 */
package com.openappengine.gui.engine.ui.params;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class Param implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private boolean required;
	
	private String valueRef;
	
	public Param(String name) {
		this(name,false);
	}

	public Param(String name, boolean required) {
		super();
		this.name = name;
		this.required = required;
	}
	
	public Param(String name, boolean required, String valueRef) {
		super();
		this.name = name;
		this.required = required;
		this.valueRef = valueRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Param other = (Param) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getValueRef() {
		return valueRef;
	}

	public void setValueRef(String valueRef) {
		this.valueRef = valueRef;
	}
}
