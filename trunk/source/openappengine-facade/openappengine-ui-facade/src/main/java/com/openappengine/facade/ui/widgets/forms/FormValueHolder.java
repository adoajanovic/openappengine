/**
 * 
 */
package com.openappengine.facade.ui.widgets.forms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.params.Param;
import com.openappengine.facade.ui.resolver.EntityValueResolver;
import com.openappengine.facade.ui.resolver.ScreenContextVariableResolver;
import com.openappengine.facade.ui.resolver.ValueResolver;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class FormValueHolder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Object value = null;
	
	private boolean initilized = false;
	
	private ValueResolver valueResolver;
	
	private Form parentForm;

	/**
	 * @param form
	 */
	public FormValueHolder(Form form) {
		this.parentForm = form;
	}

	//TODO - Get Value based on a reference imparted into this form.
	public Object getValue() {
		if (!initilized) {
			if (parentForm.getEntityReference() != null) {
				Map<Param, Object> parameterMap = parentForm.getFormParams()
						.getParameterMap();
				Map<String, Object> inParams = new HashMap<String, Object>();
				if (parameterMap != null) {
					Set<Param> params = parameterMap.keySet();
					for (Param param : params) {
						inParams.put(param.getName(), parameterMap.get(param));
					}
				}
				valueResolver = new EntityValueResolver(parentForm.getEntityReference().getEntityName(), inParams);
			} else if (parentForm.getEntityValueRef() != null) {
				valueResolver = new ScreenContextVariableResolver(ScreenContext.getCurrentInstance(),parentForm.getEntityValueRef());
			}
			// TODO - Add Service Reference in else part or use a factory.
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

}
