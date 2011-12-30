/**
 * 
 */
package com.openappengine.web.filter;

import com.openappengine.facade.core.context.ScreenApplicationContext;


/**
 * @author hrishikesh.joshi
 * @Dec 23, 2011
 */
public class ScreenContextThreadLocal {
	
	private static final ThreadLocal<ScreenApplicationContext> CURRENT_SCREEN_APPLICATION_CONTEXT = new ThreadLocal<ScreenApplicationContext>();
	
	public static ScreenApplicationContext get() {
		return CURRENT_SCREEN_APPLICATION_CONTEXT.get();
	}
	
	public static void set(ScreenApplicationContext screen) {
		CURRENT_SCREEN_APPLICATION_CONTEXT.set(screen);
	}
	
	public static void remove() {
		CURRENT_SCREEN_APPLICATION_CONTEXT.remove();
	}

}
