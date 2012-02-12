/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.facade.core.component.value.FieldMapComponent;
import com.openappengine.facade.core.executor.annotations.Action;

/**
 * @author hrishi 
 * since Dec 31, 2011
 */
@Action(actionName="entity-find-one")
public class EntityFindOneActionComponent extends AbstractEntityActionTag {

	private static final long serialVersionUID = 1L;

	private List<FieldMapComponent> fieldMaps = new ArrayList<FieldMapComponent>();

	private boolean autoFieldMap = false;
	
	private String autoFieldPrefix;
	
	private String autoFieldPrefixDelimiter = ".";

	private String conditionExpression;
	
	@Override
	public String getComponentName() {
		return "entity-find-one";
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
	
	public String getAutoFieldPrefix() {
		return autoFieldPrefix;
	}

	public void setAutoFieldPrefix(String autoFieldPrefix) {
		this.autoFieldPrefix = autoFieldPrefix;
	}

	public String getAutoFieldPrefixDelimiter() {
		return autoFieldPrefixDelimiter;
	}

	public void setAutoFieldPrefixDelimiter(String autoFieldPrefixDelimiter) {
		this.autoFieldPrefixDelimiter = autoFieldPrefixDelimiter;
	}
}
