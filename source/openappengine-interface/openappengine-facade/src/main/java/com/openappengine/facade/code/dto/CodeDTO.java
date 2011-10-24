/**
 * 
 */
package com.openappengine.facade.code.dto;

import java.io.Serializable;

/**
 * @author hrishi
 *
 */
public class CodeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String label;
	
	private String  value;
	
	private String type;
	
	public CodeDTO() {
	}

	public CodeDTO(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
