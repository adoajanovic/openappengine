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

	private String type;
	
	private boolean primaryKey;
	
	public FieldDefinition(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
}
