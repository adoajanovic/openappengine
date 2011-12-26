/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import com.openappengine.facade.ui.context.ScreenContext;


/**
 * @author hrishi
 *
 */
public class ScreenContextVariableResolver implements ValueResolver {
	
	private String variableName;
	
	public ScreenContextVariableResolver(String variableName) {
		super();
		this.variableName = variableName;
	}

	@Override
	public Object resolveValue() {
		return ScreenContext.getCurrentInstance().getVariable(variableName);
	}

}
