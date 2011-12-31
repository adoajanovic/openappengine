/**
 * 
 */
package com.openappengine.facade.core.component.executable;

import java.util.HashMap;
import java.util.Map;

import com.openappengine.facade.ui.resolver.ValueRef;

/**
 * @author hrishi since Dec 31, 2011
 */
public class EntityFindOneAction extends AbstractExecutableComponent {

	private static final long serialVersionUID = 1L;

	private String entityName;

	private Map<String, ValueRef<Object>> andParameterMap = new HashMap<String, ValueRef<Object>>();

	private boolean autoFieldMap = false;

	private String valueField;

	private String conditionExpression;

	@Override
	public String getComponentName() {
		return "entity-find-one";
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName the entityName to set
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * @return the andParameterMap
	 */
	public Map<String, ValueRef<Object>> getAndParameterMap() {
		return andParameterMap;
	}

	/**
	 * @param andParameterMap the andParameterMap to set
	 */
	public void setAndParameterMap(Map<String, ValueRef<Object>> andParameterMap) {
		this.andParameterMap = andParameterMap;
	}

	/**
	 * @return the autoFieldMap
	 */
	public boolean isAutoFieldMap() {
		return autoFieldMap;
	}

	/**
	 * @param autoFieldMap the autoFieldMap to set
	 */
	public void setAutoFieldMap(boolean autoFieldMap) {
		this.autoFieldMap = autoFieldMap;
	}

	/**
	 * @return the valueField
	 */
	public String getValueField() {
		return valueField;
	}

	/**
	 * @param valueField the valueField to set
	 */
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	/**
	 * @return the conditionExpression
	 */
	public String getConditionExpression() {
		return conditionExpression;
	}

	/**
	 * @param conditionExpression the conditionExpression to set
	 */
	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
}
