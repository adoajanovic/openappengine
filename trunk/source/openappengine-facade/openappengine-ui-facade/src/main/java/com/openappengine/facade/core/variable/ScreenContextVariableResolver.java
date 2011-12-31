/**
 * 
 */
package com.openappengine.facade.core.variable;

import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.facade.core.UIRoot;
import com.openappengine.facade.core.context.ScreenApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ScreenContextVariableResolver implements VariableResolver {
	
	private ScreenApplicationContext context;
	
	public ScreenContextVariableResolver(ScreenApplicationContext context) {
		Assert.notNull(context,"ScreenApplicationContext cannot be null.");
		setScreenApplicationContext(context);
	}

	@Override
	public Object getValue(String name) {
		UIRoot uiRoot = context.getUIRoot();
		if(uiRoot == null) {
			return null;
		}
		
		Map<String, Variable> variables = uiRoot.getScreenVariables();
		if(variables == null) {
			return null;
		}
		
		return variables.get(name);
	}

	@Override
	public void setScreenApplicationContext(ScreenApplicationContext context) {
		this.context = context;
	}

}
