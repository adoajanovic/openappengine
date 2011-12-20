/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private List<FieldDefinition> pkFields = new ArrayList<FieldDefinition>();
	
	private Map<String,FieldDefinition> fieldDefinitionMap = new HashMap<String, FieldDefinition>();

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
		processFieldDefinitions(fields);
	}

	/**
	 * @param fields
	 */
	protected void processFieldDefinitions(List<FieldDefinition> fields) {
		for (FieldDefinition fieldDefinition : fields) {
			fieldDefinitionMap.put(fieldDefinition.getName(), fieldDefinition);
			addPKFields(fieldDefinition);
		}
	}

	/**
	 * @param fieldDefinition
	 */
	protected void addPKFields(FieldDefinition fieldDefinition) {
		if(fieldDefinition.isPk()) {
			pkFields.add(fieldDefinition);
		}
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

	protected Map<String,FieldDefinition> getFieldDefinitionMap() {
		return fieldDefinitionMap;
	}

	protected void setFieldDefinitionMap(Map<String,FieldDefinition> fieldDefinitionMap) {
		this.fieldDefinitionMap = fieldDefinitionMap;
	}

	public FieldDefinition getFieldDefinition(String fieldName) {
		return fieldDefinitionMap.get(fieldName);
	}

	public List<FieldDefinition> getPKFields() {
		return pkFields;
	}

	public void setPrimaryKeyField(List<FieldDefinition> primaryKeyFields) {
		this.pkFields = primaryKeyFields;
	}
}