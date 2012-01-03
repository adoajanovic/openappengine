/**
 * 
 */
package com.openappengine.facade.core.support;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * The DataBeanWrapper class encapsulates a wrapped object, 
 * whose fields can be set dynamically by their field names.
 * 
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
		throw new UnsupportedOperationException();
	}

	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException();
	}

	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		throw new UnsupportedOperationException();
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
		if(beanWrapper.isWritableProperty(key)) {
			beanWrapper.setPropertyValue(key, value);
		} else {
			thisWrapper.setPropertyValue(key, value);
		}
		return null;
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		throw new UnsupportedOperationException();
	}

	public Object remove(Object key) {
		return null;
	}

	public int size() {
		throw new UnsupportedOperationException();
	}

	public Collection<Object> values() {
		throw new UnsupportedOperationException();
	}
	
	public Object getWrappedInstance() {
		return beanWrapper.getWrappedInstance();
	}

}
