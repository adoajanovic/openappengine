/**
 * 
 */
package com.openappengine.entity.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.openappengine.entity.delegator.Delegator;
import com.openappengine.entity.model.ModelEntity;
import com.openappengine.entity.model.ModelEntityUtils;
import com.openappengine.entity.model.ModelField;
import com.openappengine.entity.model.ModelRelationship;
import com.openappengine.utility.ObjectConverter;

/**
 * @author hrishi
 * since Mar 5, 2012
 */
public class GenericEntity implements Map<String, Object>,Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> fieldValues = new HashMap<String, Object>();
	
	private Map<String,ValueEntity> oneMappedRelatedValueEntityMap = new HashMap<String, ValueEntity>();
	
	private Map<String,Set<ValueEntity>> manyMappedRelatedValueEntityMap = new HashMap<String, Set<ValueEntity>>();
	
	private transient Delegator delegator;
	
	private ModelEntity modelEntity;
	
	private String entityName;
	
	public void init(ModelEntity modelEntity) {
		if(modelEntity == null) {
			throw new IllegalArgumentException("ModelEntity cannot be null.");
		}
		this.modelEntity = modelEntity;
		this.entityName = modelEntity.getEntityName();
	}
	
	public void init(ModelEntity modelEntity,Delegator delegator) {
		init(modelEntity);
		if(delegator == null) {
			//TODO Create Delegator
		}
		this.delegator = delegator;
		
		initNullFieldValues(modelEntity);
	}

	/**
	 * @param modelEntity
	 */
	private void initNullFieldValues(ModelEntity modelEntity) {
		Set<ModelField> modelFields = modelEntity.getModelFields();
		if(modelFields != null) {
			for (ModelField modelField : modelFields) {
				fieldValues.put(modelField.getName(), null);
			}
		}
	}
	
	public void init(ModelEntity modelEntity,Delegator delegator,Map<String, Object> fieldValueMap) {
		init(modelEntity, delegator);
		this.setFieldValues(fieldValueMap);
	}
	
	//Implementations of Map.
	@Override
	public int size() {
		return getFieldValues().size();
	}

	@Override
	public boolean isEmpty() {
		return getFieldValues().isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return fieldValues.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return fieldValues.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		return fieldValues.get(key);
	}

	@Override
	public Object put(String field, Object value) {
		ModelField modelField = getModelEntity().getModelField(field);
		String type = modelField.getType();
		Class<?> fieldTypeClass;
		try {
			fieldTypeClass = ModelEntityUtils.getModelFieldType(type);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("No Class found for Type: " + type + ". Cannot save the field " + field + ".");
		}
		
		Object convertedVal = value;
		
		if(value != null) {
			convertedVal = ObjectConverter.convert(value, fieldTypeClass);
		}
		return fieldValues.put(field, convertedVal);
	}

	@Override
	public Object remove(Object key) {
		return fieldValues.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		fieldValues.putAll(m);
	}

	@Override
	public void clear() {
		fieldValues.clear();
	}

	@Override
	public Set<String> keySet() {
		return fieldValues.keySet();
	}

	@Override
	public Collection<Object> values() {
		return fieldValues.values();
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return fieldValues.entrySet();
	}
	//Map Interface.
	
	public List<ModelRelationship> getModelRelationships() {
		return getModelEntity().getRelationships();
	}
	
	public ModelRelationship getModelRelationship(String relationName) {
		return getModelEntity().getModelRelationshipByName(relationName);
	}

	public ModelEntity getModelEntity() {
		return modelEntity;
	}

	public void setModelEntity(ModelEntity modelEntity) {
		this.modelEntity = modelEntity;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Map<String, Object> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(Map<String, Object> fieldValues) {
		this.fieldValues = fieldValues;
	}
	
	public boolean isRequired(String field) {
		ModelField modelField = getModelEntity().getModelField(field);
		return modelField.isRequired();
	}

	public Delegator getDelegator() {
		return delegator;
	}

	public Map<String,ValueEntity> getOneMappedRelatedValueEntityMap() {
		return oneMappedRelatedValueEntityMap;
	}

	public void setOneMappedRelatedValueEntityMap(Map<String,ValueEntity> relatedValueEntityMap) {
		this.oneMappedRelatedValueEntityMap = relatedValueEntityMap;
	}

	public Map<String,Set<ValueEntity>> getManyMappedRelatedValueEntityMap() {
		return manyMappedRelatedValueEntityMap;
	}

	public void setManyMappedRelatedValueEntityMap(
			Map<String,Set<ValueEntity>> manyMappedRelatedValueEntityMap) {
		this.manyMappedRelatedValueEntityMap = manyMappedRelatedValueEntityMap;
	}

}
