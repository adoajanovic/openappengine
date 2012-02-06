/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import com.openappengine.facade.entity.validator.DefaultEntityValidator;
import com.openappengine.facade.entity.validator.EntityValidator;

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
	
	private EntityValidator entityValidator = new DefaultEntityValidator(this);
	
	private Document document;
	
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
	
	public void addFieldDefinition(FieldDefinition field) {
		if(field == null) {
			return;
		}
		fields.add(field);
		fieldDefinitionMap.put(field.getName(), field);
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
	
	public boolean containsFieldDefinitionByFieldName(String fieldName) {
		return fieldDefinitionMap.containsKey(fieldName);
	}
	
	public boolean containsFieldDefinitionByFieldRef(FieldDefinition field) {
		if(fields != null) {
			for (FieldDefinition fieldDef : fields) {
				if(StringUtils.equals(fieldDef.getProperty(),field.getProperty())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<FieldDefinition> getPKFields() {
		if(pkFields != null) {
			for (FieldDefinition field : fields) {
				if(field.isPk()) {
					pkFields.add(field);
				}
			}
		}
		return pkFields;
	}

	public void setPrimaryKeyField(List<FieldDefinition> primaryKeyFields) {
		this.pkFields = primaryKeyFields;
	}

	public EntityValidator getEntityValidator() {
		return entityValidator;
	}

	public void setEntityValidator(EntityValidator entityValidator) {
		this.entityValidator = entityValidator;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}