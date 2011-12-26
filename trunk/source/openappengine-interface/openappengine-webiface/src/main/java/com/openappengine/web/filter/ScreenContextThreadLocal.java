/**
 * 
 */
package com.openappengine.web.filter;

import com.openappengine.facade.ui.context.ScreenContext;

/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class ScreenContextThreadLocal {
	
	private static final ThreadLocal<ScreenContext> CURRENT_SCREEN_CONTEXT = new ThreadLocal<ScreenContext>();
	
	public static ScreenContext get() {
		return CURRENT_SCREEN_CONTEXT.get();
	}
	
	public static void set(ScreenContext screen) {
		CURRENT_SCREEN_CONTEXT.set(screen);
	}
	
	public static void remove() {
		CURRENT_SCREEN_CONTEXT.remove();
	}

}
