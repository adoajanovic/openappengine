/**
 * 
 */
package com.openappengine.web.filter;

import com.openappengine.facade.core.context.GuiApplicationContext;


/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class ScreenContextThreadLocal {
	
	private static final ThreadLocal<GuiApplicationContext> CURRENT_SCREEN_APPLICATION_CONTEXT = new ThreadLocal<GuiApplicationContext>();
	
	public static GuiApplicationContext get() {
		return CURRENT_SCREEN_APPLICATION_CONTEXT.get();
	}
	
	public static void set(GuiApplicationContext screen) {
		CURRENT_SCREEN_APPLICATION_CONTEXT.set(screen);
	}
	
	public static void remove() {
		CURRENT_SCREEN_APPLICATION_CONTEXT.remove();
	}

}
