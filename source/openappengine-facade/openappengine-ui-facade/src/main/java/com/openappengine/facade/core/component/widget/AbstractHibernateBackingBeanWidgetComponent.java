package com.openappengine.facade.core.component.widget;

import java.util.List;

import com.openappengine.facade.core.component.AbstractGuiComponent;
import com.openappengine.facade.core.component.ui.EntityValueAware;
import com.openappengine.facade.core.component.widget.backingbean.HibernateBackingBeanWidget;
import com.openappengine.facade.entity.EntityValue;
import com.openappengine.facade.entity.definition.FieldDefinition;

public abstract class AbstractHibernateBackingBeanWidgetComponent extends AbstractGuiComponent implements HibernateBackingBeanWidget,EntityValueAware {

	private static final long serialVersionUID = 1L;
	
	private String entityValueRef;
	
	private EntityValue entityValue;
	
	private boolean entityValueSet = false;

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
			instance = entityValue.getWrappedInstance();
		}
		return instance;
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
	
	@Override
	public String getEntityName() {
		if(entityValue != null) {
			return entityValue.getEntityName();
		}
		return null;
	}
}
