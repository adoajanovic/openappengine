/**
 * 
 */
package com.openappengine.web.filter;

import com.openappengine.facade.ui.screen.Screen;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class ScreenThreadLocalContext {
	
	private static final ThreadLocal<Screen> CURRENT_SCREEN_CONTEXT = new ThreadLocal<Screen>();
	
	public static Screen get() {
		return CURRENT_SCREEN_CONTEXT.get();
	}
	
	public static void set(Screen screen) {
		CURRENT_SCREEN_CONTEXT.set(screen);
	}
	
	public static void remove() {
		CURRENT_SCREEN_CONTEXT.remove();
	}

}
