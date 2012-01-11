package com.openappengine.facade.core.component.ui;

import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.definition.FieldDefinition;

public class FormSingleComponent extends AbstractGuiComponent implements EntityValueAware {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String entityValueRef;
	
	private EntityValue entityValue;
	
	private boolean entityValueSet = false;

	@Override
	public String getComponentType() {
		return "forms";
	}

	@Override
	public String getComponentName() {
		return "form";
	}

	public EntityValue getValue() {
		return entityValue;
	}
	
	public Object getFormCommand() {
		return entityValue.getInstance();
	}
	
	public List<FieldDefinition> getFormFields() {
		return entityValue.getEntityDefinition().getFields();
	}
	
	public Object getFormCommandValue(String property) {
		return entityValue.get(property);
	}

	public void setValue(EntityValue entityValue) {
		this.entityValue = entityValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isValueSet() {
		return entityValueSet;
	}

	public void setEntityValueSet(boolean entityValueSet) {
		this.entityValueSet = entityValueSet;
	}

	public String getEntityValueRef() {
		return entityValueRef;
	}

	public void setEntityValueRef(String entityValueRef) {
		this.entityValueRef = entityValueRef;
	}

	@Override
	public String getValueRef() {
		return entityValueRef;
	}

}
