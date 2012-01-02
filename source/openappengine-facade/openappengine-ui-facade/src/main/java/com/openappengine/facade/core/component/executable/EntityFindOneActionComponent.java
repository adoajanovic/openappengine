/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.value.FieldMapComponent;
import com.openappengine.facade.core.executor.action.Executable;
import com.openappengine.facade.core.executor.action.entity.EntityFindOneAction;

/**
 * @author hrishi 
 * since Dec 31, 2011
 */
public class EntityFindOneActionComponent extends AbstractExecutableComponent {

	private static final long serialVersionUID = 1L;

	private String entityName;

	private List<FieldMapComponent> fieldMaps = new ArrayList<FieldMapComponent>();

	private boolean autoFieldMap = false;

	private String valueField;

	private String conditionExpression;
	
	@Override
	public String getComponentName() {
		return "entity-find-one";
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public boolean isAutoFieldMap() {
		return autoFieldMap;
	}

	public void setAutoFieldMap(boolean autoFieldMap) {
		this.autoFieldMap = autoFieldMap;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}

	public List<FieldMapComponent> getFieldMaps() {
		return fieldMaps;
	}

	public void setFieldMaps(List<FieldMapComponent> fieldMaps) {
		this.fieldMaps = fieldMaps;
	}
	
	public void addFieldMap(FieldMapComponent fieldMapComponent) {
		if(fieldMapComponent == null) {
			return;
		}
		this.fieldMaps.add(fieldMapComponent);
	}

	@Override
	public Executable getExecutable() {
		EntityFindOneAction entityFindOneAction = new EntityFindOneAction(this.getEntityName());
		entityFindOneAction.setAndParameterMap(null);//TODO
		entityFindOneAction.setAutoFieldMap(this.isAutoFieldMap());
		entityFindOneAction.setConditionExpression(this.getConditionExpression());
		entityFindOneAction.setOutgoingTransition(null);//TODO
		entityFindOneAction.setValueField(this.getValueField());
		return entityFindOneAction;
	}
}
