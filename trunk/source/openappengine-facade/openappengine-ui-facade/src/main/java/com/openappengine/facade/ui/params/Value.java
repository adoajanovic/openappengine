/**
 * 
 */
package com.openappengine.facade.ui.params;

import java.io.Serializable;

import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * @author hrishi
 *
 */
public class Value implements Serializable {

	private static final long serialVersionUID = 1L;

	private ValueResolver valueResolver;
	
	private Object value;
	
	private boolean resolved;
	
	public Value(ValueResolver valueResolver) {
		super();
		this.valueResolver = valueResolver;
	}

	public Object getValue() {
		if(!resolved) {
			value = valueResolver.resolveValue();
		}
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public ValueResolver getValueResolver() {
		return valueResolver;
	}

	public void setValueResolver(ValueResolver valueResolver) {
		this.valueResolver = valueResolver;
	}

	public boolean isResolved() {
		return resolved;
	}

	protected void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

}
