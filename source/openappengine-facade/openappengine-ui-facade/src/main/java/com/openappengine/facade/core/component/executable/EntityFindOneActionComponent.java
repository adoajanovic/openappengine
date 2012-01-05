/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.component.value.FieldMapComponent;
import com.openappengine.facade.core.executor.action.Executable;
import com.openappengine.facade.core.executor.action.entity.EntityFindOneActionHandler;
import com.openappengine.facade.core.executor.action.request.DefaultActionRequest;

/**
 * @author hrishi 
 * since Dec 31, 2011
 */
public class EntityFindOneActionComponent extends AbstractExecutableComponent {

	private static final long serialVersionUID = 1L;

	private String entityName;

	private List<FieldMapComponent> fieldMaps = new ArrayList<FieldMapComponent>();

	private boolean autoFieldMap = false;

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
	public ActionRequest getActionRequest() {
		ActionRequest actionRequest = new DefaultActionRequest("entity-find-one");
		actionRequest.addActionParameter("entityName", entityName);
		actionRequest.addActionParameter("autoFieldMap", autoFieldMap);
		actionRequest.addActionParameter("conditionExpression", conditionExpression);
		//TODO
		//actionRequest.addActionParameter("fieldMaps", fieldMaps);
		return actionRequest;
	}
}
