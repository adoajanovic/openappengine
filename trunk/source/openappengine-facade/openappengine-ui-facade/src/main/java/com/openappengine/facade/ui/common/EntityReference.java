/**
 * 
 */
package com.openappengine.facade.ui.common;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class EntityReference implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum IncludeFields {
		ALL,PK_FIELDS,NON_PK_FIELDS,REFERENCED;
	}
	
	/**
	 *  Used as a reference to the EntityDefinition keyed by their entity-names. 
	 */
	private String entityName;
	
	private IncludeFields includeFields = IncludeFields.ALL;
	
	public EntityReference(String entityName) {
		super();
		Validate.notEmpty(entityName,"EntityName cannot be null or empty.");
		this.entityName = entityName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		Validate.notEmpty(entityName,"EntityName cannot be null or empty.");
		this.entityName = entityName;
	}

	public IncludeFields getIncludeFields() {
		return includeFields;
	}

	public void setIncludeFields(IncludeFields includeFields) {
		this.includeFields = includeFields;
	}

}
