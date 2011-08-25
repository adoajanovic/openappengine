/**
 * 
 */
package com.ms.openapps.model.user;

/**
 * @author hrishi
 *
 */
public class LoggedUserNameContext {

	private static final ThreadLocal<String> loggedUserNameThreadLocal = new ThreadLocal<String>();
	
	public static void set(String sessionId) {
		loggedUserNameThreadLocal.set(sessionId);
	}
	
	public static String get() {
		return loggedUserNameThreadLocal.get();
	}
	
	public static void remove() {
		loggedUserNameThreadLocal.remove();
	}
	
}
