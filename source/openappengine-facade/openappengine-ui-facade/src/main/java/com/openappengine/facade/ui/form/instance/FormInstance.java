/**
 * 
 */
package com.openappengine.facade.ui.form.instance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.form.FormDefinition;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormInstance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  The FormDefinition from which this FormInstance was created.
	 */
	private FormDefinition formDefinition;
	
	/**
	 *  The actual entity value.
	 */
	private EntityValue entityValue;
	
	/**
	 *  The actual fieldDefinitions fetched based all the include-mode.
	 *  //TODO - Handle logic in the Component - entityForm.
	 */
	private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
	
	private Map<String, FieldDefinition> fieldDefinitionMap = new HashMap<String, FieldDefinition>();
	
	public FormInstance(FormDefinition formDefinition) {
		this.setFormDefinition(formDefinition);
	}

	/**
	 * 
	 */
	public FormInstance() {
	}

	public EntityValue getEntityValue() {
		return entityValue;
	}

	public void setEntityValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}

	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}

	public List<FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
		if(fieldDefinitions != null) {
			for (FieldDefinition fieldDefinition : fieldDefinitions) {
				fieldDefinitionMap.put(fieldDefinition.getName(), fieldDefinition);
			}
		}
	}

	public Map<String, FieldDefinition> getFieldDefinitionMap() {
		return fieldDefinitionMap;
	}

	protected void setFieldDefinitionMap(Map<String, FieldDefinition> fieldDefinitionMap) {
		this.fieldDefinitionMap = fieldDefinitionMap;
	}
	
	public FieldDefinition getFieldDefinition(String fieldName) {
		return fieldDefinitionMap.get(fieldName);
	}
	
}
