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
	
	private ScreenContext screenContext;
	
	public ScreenContextVariableResolver(ScreenContext screenContext,String variableName) {
		super();
		this.variableName = variableName;
		this.screenContext = screenContext;
	}

	@Override
	public Object resolveValue() {
		Screen screen = screenContext.getScreen();
		if(screen != null) {
			return screen.getVariable(variableName);
		}
		return null;
	}

}
