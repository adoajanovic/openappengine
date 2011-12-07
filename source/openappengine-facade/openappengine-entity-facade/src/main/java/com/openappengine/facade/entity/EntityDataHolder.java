/**
 */
package com.openappengine.facade.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.openappengine.facade.entity.exception.InvalidEntityAccessException;


/**
 * This class represents one single record of the entity.
 * 
 * @author hrishikesh.joshi
 *
 */
public class EntityDataHolder extends DataBeanWrapper {
	
	private Object entity;
	
	private Object originalEntity;
	
	private String entityName;
	
	/**
	 * @param object
	 */
	public EntityDataHolder(Object object) {
		super(object);
		this.setEntity(object);
		this.setOriginalEntity(object);
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
	
	/**
	 * Get the value of the named-property.
	 * @param property
	 * @return
	 */
	public Object get(String property) {
		return super.get(property);
	}
	
	/**
	 * Sets the named property.
	 * @param propertyName
	 * @param value
	 * @return the modified entity instance
	 */
	public void set(String propertyName,Object value) {
		super.put(propertyName, value);
	}
	
	public Boolean getBoolean(String property) {
		Object value = super.get(property);
		if(!(value instanceof Boolean)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a Boolean.");
		}
		return (Boolean) value;
	}
	
	public String getString(String property) {
		Object value = super.get(property);
		if(!(value instanceof String)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a String.");
		}
		return (String) value;
	}
	
	public Date getDate(String property) {
		Object value = super.get(property);
		if(!(value instanceof Date)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a Date.");
		}
		return (Date) value;
	}
	
	public Integer getInteger(String property) {
		Object value = super.get(property);
		if(!(value instanceof Integer)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a Integer.");
		}
		return (Integer) value;
	}
	
	public Double getDouble(String property) {
		Object value = super.get(property);
		if(!(value instanceof Double)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a Double.");
		}
		return (Double) value;
	}
	
	public BigDecimal getBigDecimal(String property) {
		Object value = super.get(property);
		if(!(value instanceof BigDecimal)) {
			throw new InvalidEntityAccessException("Property : " + property + " is not a BigDecimal.");
		}
		return (BigDecimal) value;
	}
	//TODO - Create similar methods - getString getDate etc.
	
	public boolean isModified() {
		//TODO
		return false;
	}

	public Object getOriginalEntity() {
		return originalEntity;
	}

	public void setOriginalEntity(Object originalEntity) {
		this.originalEntity = originalEntity;
	}
	
	public void refresh() {
		//TODO
	}
	
	public EntityDataHolder create() {
		//TODO
		return this;
	}
	
	public void delete() {
		//TODO
	}
	
	public EntityDataHolder update() {
		//TODO
		return this;
	}
	
	public EntityDataHolder createOrUpdate() {
		//TODO
		return this;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
}