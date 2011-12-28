/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import com.openappengine.facade.ui.context.ScreenContext;
import com.openappengine.facade.ui.screen.Screen;


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
		ScreenContext screenContext = ScreenContext.getCurrentInstance();
		Screen screen = screenContext.getScreen();
		if(screen != null) {
			return screen.getVariable(variableName);
		}
		return null;
	}

}
