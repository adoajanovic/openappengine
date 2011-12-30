/**
 * 
 */
package com.openappengine.facade.ui.context;

import com.openappengine.facade.ui.screen.Screen;
/**
 * @author hrishi
 *
 */
public class ScreenApplicationContext {
	
	private Screen screen;
	
	private static ScreenApplicationContext currentInstance;
	
	public static ScreenApplicationContext getCurrentInstance() {
		return currentInstance;
	}
	
	public static void setCurrentInstance(ScreenApplicationContext screenContext) {
		currentInstance = screenContext;
	}
	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}
}

