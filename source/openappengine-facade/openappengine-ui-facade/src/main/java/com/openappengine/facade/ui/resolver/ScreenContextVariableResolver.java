/**
 * 
 */
package com.openappengine.facade.ui.resolver;

import com.openappengine.facade.ui.context.ScreenApplicationContext;
import com.openappengine.facade.ui.screen.Screen;


/**
 * @author hrishi
 *
 */
public class ScreenContextVariableResolver implements ValueResolver {
	
	private String variableName;
	
	private ScreenApplicationContext screenContext;
	
	public ScreenContextVariableResolver(ScreenApplicationContext screenContext,String variableName) {
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
