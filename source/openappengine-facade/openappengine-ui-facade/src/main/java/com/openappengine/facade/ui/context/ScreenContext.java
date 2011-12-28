/**
 * 
 */
package com.openappengine.facade.ui.context;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishi
 *
 */
public class ScreenContext {
	
	private Screen screen;
	
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
}
