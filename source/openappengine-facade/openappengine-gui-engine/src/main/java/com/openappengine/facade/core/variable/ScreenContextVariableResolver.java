/**
 * 
 */
package com.openappengine.facade.core.variable;

import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.facade.core.component.ui.GuiRootComponent;
import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ScreenContextVariableResolver implements VariableResolver {
	
	private GuiApplicationContext context;
	
	public ScreenContextVariableResolver(GuiApplicationContext context) {
		Assert.notNull(context,"ScreenApplicationContext cannot be null.");
		setGuiApplicationContext(context);
	}

	@Override
	public Object getValue(String name) {
		GuiRootComponent uiRoot = context.getUIRoot();
		if(uiRoot == null) {
			return null;
		}
		
		Map<String, Variable> variables = uiRoot.getScreenVariables();
		if(variables == null) {
			return null;
		}
		
		Variable variable = variables.get(name);
		if(variable != null) {
			return variable.getValue();
		}
		
		return null;
	}

	@Override
	public void setGuiApplicationContext(GuiApplicationContext context) {
		this.context = context;
	}

}
