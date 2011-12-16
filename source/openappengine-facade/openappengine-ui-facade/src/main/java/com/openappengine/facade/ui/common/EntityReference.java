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
		ALL,	//Include All the fields given in the referenced entity definition.
		PK_FIELDS, //Include All the PK-Fields given in the referenced entity definition.
		NON_PK_FIELDS, //Include All the Non-PK Fields given in the referenced entity definition.
		REFERENCED; //Include All the fields referenced entity definition in the field-layout.
	}
	
	/**
	 *  Used as a reference to the EntityDefinition keyed by their entity-names. 
	 */
	private String entityName;
	
	/**
	 *  Fields to be included in this form.
	 */
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
