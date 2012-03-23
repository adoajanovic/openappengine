/**
 * 
 */
package com.openappengine.entity;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @author hrishi
 * 
 */
public class DataBeanWrapper implements Map<String, Object> {

	private BeanWrapper beanWrapper;

	private BeanWrapper thisWrapper;

	public DataBeanWrapper(Object object) {
		init(object);
	}

	public void init(Object object) {
		beanWrapper = new BeanWrapperImpl(object);
		thisWrapper = new BeanWrapperImpl(this);
	}

	public void clear() {
	}

	public boolean containsKey(Object key) {
		try {
			PropertyDescriptor propertyDescriptor = beanWrapper.getPropertyDescriptor((String) key);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public boolean containsValue(Object value) {
		return true;
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return new HashSet<Map.Entry<String,Object>>();
	}

	public Object get(Object key) {
		String objectKey = (String) key;
		if (beanWrapper.isReadableProperty(objectKey)) {
			return beanWrapper.getPropertyValue(objectKey);
		} else {
			return thisWrapper.getPropertyValue(objectKey);
		}
	}

	public boolean isEmpty() {
		return false;
	}

	public Set<String> keySet() {
		throw new UnsupportedOperationException();
	}

	public Object put(String key, Object value) {
		beanWrapper.setPropertyValue(key, value);
		return null;
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		throw new UnsupportedOperationException();
	}

	public Object remove(Object key) {
		return null;
	}

	public int size() {
		PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
		return propertyDescriptors.length;
	}

	public Collection<Object> values() {
		throw new UnsupportedOperationException();
	}
	
	public Object getWrappedInstance() {
		return beanWrapper.getWrappedInstance();
	}

}
