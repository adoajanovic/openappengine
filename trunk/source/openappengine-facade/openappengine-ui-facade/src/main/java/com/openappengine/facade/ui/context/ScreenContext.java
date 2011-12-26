/**
 * 
 */
package com.openappengine.facade.ui.context;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishi
 *
 */
public class ScreenContext {
	
	private Screen screen;
	
	private Map<String,Variable> variableMap = new HashMap<String, Variable>();
	
	private static ScreenContext currentInstance;
	
	public static ScreenContext getCurrentInstance() {
		return currentInstance;
	}
	
	public static void setCurrentInstance(ScreenContext screenContext) {
		currentInstance = screenContext;
	}
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Map<String,Variable> getVariableMap() {
		return variableMap;
	}

	public void putVariable(String variableName, Object object) {
		if (!StringUtils.isEmpty(variableName) && object != null) {
			Variable value = new Variable();
			value.setName(variableName);
			value.setValue(object);
			this.variableMap.put(variableName, value);
		}
	}
	
	public Object getVariable(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		
		Variable variable = variableMap.get(name);
		if(variable != null) {
			return variable.getValue();
		}
		
		return null;
	}
}
