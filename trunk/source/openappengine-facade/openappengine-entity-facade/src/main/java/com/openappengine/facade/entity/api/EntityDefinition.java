/**
 * 
 */
package com.openappengine.facade.entity.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String entityName;
	
	private String entityClassName;
	
	private Set<FieldDefinition> fields = new HashSet<FieldDefinition>();

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Set<FieldDefinition> getFields() {
		return fields;
	}

	public void setFields(Set<FieldDefinition> fields) {
		this.fields = fields;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

}
