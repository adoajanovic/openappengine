/**
 * 
 */
package com.openappengine.facade.ui.form.instance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public FormInstance(FormDefinition formDefinition) {
		this.setFormDefinition(formDefinition);
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
	}
	
}
