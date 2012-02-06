package com.openappengine.facade.core.component.widget;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.ui.EntityValueAware;
import com.openappengine.facade.core.component.widget.backingbean.HibernateBackingBeanWidget;
import com.openappengine.facade.entity.PojoEntityValue;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;

public abstract class AbstractHibernateBackingBeanWidgetComponent extends AbstractGuiComponent implements HibernateBackingBeanWidget,EntityValueAware {

	private static final long serialVersionUID = 1L;
	
	private String entityValueRef;
	
	private PojoEntityValue pojoEntityValue;
	
	private List<FormFieldComponent> fields = new ArrayList<FormFieldComponent>();

	@Override
	public String getComponentType() {
		return "forms";
	}
	
	@Override
	public PojoEntityValue getValue() {
		return pojoEntityValue;
	}
	
	@Override
	public Object formBackingObject() {
		Object instance = null;
		if(pojoEntityValue != null) {
			instance = pojoEntityValue.getInstance();
		}
		return instance;
	}
	
	public List<FieldDefinition> getFormFields() {
		List<FieldDefinition> fieldsDefs = null;
		if(pojoEntityValue == null) {
			return null;
		}
		
		EntityDefinition entityDefinition = pojoEntityValue.getEntityDefinition();
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
	
	public Object getFormCommandValue(String property) {
		return pojoEntityValue.get(property);
	}

	public void setValue(PojoEntityValue pojoEntityValue) {
		this.pojoEntityValue = pojoEntityValue;
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
		if(pojoEntityValue != null) {
			return pojoEntityValue.getEntityName();
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
}
