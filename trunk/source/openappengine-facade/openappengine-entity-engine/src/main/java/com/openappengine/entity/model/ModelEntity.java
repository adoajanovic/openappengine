/**
 * 
 */
package com.openappengine.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * @author hrishikesh.joshi
 * @since  Mar 5, 2012
 *
 */
public class ModelEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String entityName;
	
	private String tableName;
	
	//Can be changed after the entity is initialized.
	private boolean mutable = true;
	
	protected Map<String, ModelField> fieldsMap = new HashMap<String, ModelField>();
	
	protected List<ModelRelationship> relationships = new ArrayList<ModelRelationship>();
	
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Set<ModelField> getModelFields() {
		return new HashSet<ModelField>(fieldsMap.values());
	}

	public void addModelField(ModelField modelField) {
		if(modelField == null) {
			throw new IllegalArgumentException("Model Field found null for Model Entity :" + entityName);
		}
		
		if(StringUtils.isEmpty(modelField.getName())) {
			throw new IllegalArgumentException("Model Field Name found null for Model Entity :" + entityName);
		}
		
		this.fieldsMap.put(modelField.getName(), modelField);
	}
	
	public void addRelationship(ModelRelationship relationship) {
		if(relationship == null) {
			throw new IllegalArgumentException("Cannot add a NULL relationship for Model Entity :" + entityName);
		}
		this.relationships.add(relationship);
	}

	public boolean isMutable() {
		return mutable;
	}

	public void setMutable(boolean mutable) {
		this.mutable = mutable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entityName == null) ? 0 : entityName.hashCode());
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
		ModelEntity other = (ModelEntity) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		return true;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
