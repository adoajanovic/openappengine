/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String entityName;
	
	private Class<?> entityClass;
	
	private boolean deleteable;
	
	private List<FieldDefinition> fields = new ArrayList<FieldDefinition>();

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public List<FieldDefinition> getFields() {
		return fields;
	}

	public void setFields(List<FieldDefinition> fields) {
		this.fields = fields;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public boolean isDeleteable() {
		return deleteable;
	}

	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}

}
