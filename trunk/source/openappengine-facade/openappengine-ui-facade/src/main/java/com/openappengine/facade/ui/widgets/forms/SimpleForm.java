/**
 * 
 */
package com.openappengine.facade.ui.widgets.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.ui.form.FormDefinition;
import com.openappengine.facade.ui.widgets.Widget;

/**
 * @author hrishikesh.joshi
 * @Dec 21, 2011
 */
public class SimpleForm extends Widget {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  Form Name.
	 */
	private String formName;
	
	/**
	 *  The FormDefinition from which this FormInstance was created.
	 */
	private FormDefinition formDefinition;
	
	/**
	 *  The actual entity value.
	 */
	private EntityValue entityValue;
	
	/**
	 *  The actual fieldDefinitions fetched based on the include-mode.
	 */
	private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
	
	/**
	 *  Field Definition Map keyed by FormNames.
	 */
	private Map<String, FieldDefinition> fieldDefinitionMap = new HashMap<String, FieldDefinition>();
	
	public SimpleForm(String formName) {
		this.setFormName(formName);
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

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
