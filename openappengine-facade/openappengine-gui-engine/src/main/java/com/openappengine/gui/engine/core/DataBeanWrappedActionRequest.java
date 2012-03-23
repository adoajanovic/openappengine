package com.openappengine.gui.engine.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class DataBeanWrappedActionRequest implements ActionRequest {

	private static final long serialVersionUID = 1L;
	
	private BeanWrapper beanWrapper;
	
	private String actionName;
	
	private String mode = MODE_XML;
	
	/**
	 * @param object
	 */
	public DataBeanWrappedActionRequest(String actionName,Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Instance cannot be null or blank.");
		}
		beanWrapper = new BeanWrapperImpl(object);
		if(StringUtils.isEmpty(actionName)) {
			throw new IllegalArgumentException("ActionName cannot be null or blank.");
		}
		this.actionName = actionName;
	}

	
	/**
	 * @param beanWrapper
	 * @param actionName
	 * @param mode
	 */
	public DataBeanWrappedActionRequest(String actionName,Object instance,String mode) {
		this(actionName, instance);
		this.mode = mode;
	}



	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public Map<String, Object> getActionParameters() {
		Class<?> wrappedClazz = beanWrapper.getWrappedInstance().getClass();
		
		Field[] fields = wrappedClazz.getDeclaredFields();
		Map<String,Object> params = new HashMap<String, Object>();
		for (Field field : fields) {
			String fieldProperty = field.getName();
			if(beanWrapper.isReadableProperty(fieldProperty)) {
				params.put(fieldProperty, beanWrapper.getPropertyValue(fieldProperty));
			}
		}
		return params;
	}

	@Override
	public void addActionParameters(Map<String, Object> params) {
		if(params == null || params.isEmpty()) {
			return;
		}
		
		beanWrapper.setPropertyValues(params);
	}

	@Override
	public void addActionParameter(String param, Object value) {
		if(StringUtils.isEmpty(param) || value==null) {
			throw new IllegalArgumentException("Param or Value is null.");
		}
		beanWrapper.setPropertyValue(param, value);
	}

	@Override
	public Object getActionParameter(String param) {
		if(beanWrapper.isReadableProperty(param)) {
			return beanWrapper.getPropertyValue(param);
		}
		return null;
	}

	@Override
	public <T> T getActionParameter(String paramKey, Class<T> t) {
		if(t == null) {
			return null;
		}
		
		if(beanWrapper.isReadableProperty(paramKey)) {
			Object val = beanWrapper.getPropertyValue(paramKey);
			return (T) val;
		}
		
		return null;
	}

	@Override
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		if(StringUtils.isEmpty(mode)) {
			return;
		}
		this.mode = mode;
	}

}
