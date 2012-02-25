/**
 * 
 */
package com.openappengine.gui.engine.core.variable;

import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.gui.engine.core.component.ui.GuiRootComponent;
import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class ScreenContextVariableResolver implements VariableResolver {
	
	private GuiEngineContext context;
	
	public ScreenContextVariableResolver(GuiEngineContext context) {
		Assert.notNull(context,"ScreenApplicationContext cannot be null.");
		setGuiApplicationContext(context);
	}

	@Override
	public Object getValue(String name) {
		Map<String, Variable> variables = context.getScreenVariables();
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
	public void setGuiApplicationContext(GuiEngineContext context) {
		this.context = context;
	}

}
