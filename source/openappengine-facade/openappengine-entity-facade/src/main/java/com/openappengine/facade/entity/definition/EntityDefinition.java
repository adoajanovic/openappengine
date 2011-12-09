/**
 * 
 */
package com.openappengine.facade.entity.definition;

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
	
	private Class<?> entityClass;
	
	private boolean deleteable;
	
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

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	public boolean isDeleteable() {
		return deleteable;
	}

	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}

}
