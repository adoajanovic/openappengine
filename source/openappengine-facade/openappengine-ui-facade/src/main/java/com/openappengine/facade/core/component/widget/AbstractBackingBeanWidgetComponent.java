package com.openappengine.facade.core.component.widget;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.ui.EntityValueAware;
import com.openappengine.facade.core.component.widget.backingbean.PojoBackingBeanWidget;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;

public abstract class AbstractBackingBeanWidgetComponent extends AbstractGuiComponent implements PojoBackingBeanWidget,EntityValueAware {

	private static final long serialVersionUID = 1L;
	
	private String entityValueRef;
	
	private EntityValue entityValue;
	
	private String mode;
	
	private List<FormFieldComponent> fields = new ArrayList<FormFieldComponent>();

	@Override
	public String getComponentType() {
		return "forms";
	}
	
	@Override
	public EntityValue getValue() {
		return entityValue;
	}
	
	@Override
	public Object formBackingObject() {
		Object instance = null;
		if(entityValue != null) {
			instance = entityValue.getInstance();
		}
		return instance;
	}
	
	public List<FieldDefinition> getFormFields() {
		List<FieldDefinition> fieldsDefs = null;
		if(entityValue == null) {
			return null;
		}
		
		EntityDefinition entityDefinition = entityValue.getEntityDefinition();
		if(fields == null || fields.isEmpty()) {
			fieldsDefs = entityDefinition.getFields();
		} else {
			fieldsDefs = new ArrayList<FieldDefinition>();
			for (FormFieldComponent formFieldDefinition : fields) {
				String entryName = formFieldDefinition.getEntryName();
				if(!entityDefinition.containsFieldDefinitionByFieldName(entryName)) {
					throw new IllegalArgumentException("Field :" + entryName + " not found in the EntityDefinition " + entityDefinition.getEntityName());
				}
				FieldDefinition fieldDefinitionEntry = entityDefinition.getFieldDefinition(entryName);
				fieldDefinitionEntry.setHidden(formFieldDefinition.isHidden());
				fieldsDefs.add(fieldDefinitionEntry);
			}
		}
		return fieldsDefs;
	}
	
	public void setValue(EntityValue pojoEntityValue) {
		this.entityValue = pojoEntityValue;
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
	
	@Override
	public String getEntityName() {
		if(entityValue != null) {
			return entityValue.getEntityName();
		}
		return null;
	}

	public List<FormFieldComponent> getFields() {
		return fields;
	}

	public void setFields(List<FormFieldComponent> fields) {
		this.fields = fields;
	}
	
	public void addField(FormFieldComponent formFieldComponent) {
		if(formFieldComponent == null) {
			return;
		}
		fields.add(formFieldComponent);
	}

	public String getWidgetMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
}
