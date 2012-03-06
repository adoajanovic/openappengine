/**
 * 
 */
package com.openappengine.entity.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.openappengine.entity.delegator.Delegator;
import com.openappengine.entity.model.ModelEntity;

/**
 * @author hrishi
 * since Mar 5, 2012
 */
public class GenericEntity implements Map<String, Object>,Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> fieldMap = new HashMap<String, Object>();
	
	protected Delegator delegator;
	
	private ModelEntity modelEntity;
	
	private String entityName;
	
	//Implementations of Map.
	@Override
	public int size() {
		return fieldMap.size();
	}

	@Override
	public boolean isEmpty() {
		return fieldMap.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	//Map Interface.

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
	
	

}
