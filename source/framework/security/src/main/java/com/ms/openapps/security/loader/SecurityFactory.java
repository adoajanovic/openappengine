/**
 * 	Factory Class for injecting the AppSecurity Service into the Application Context
 */
package com.ms.openapps.security.loader;

import org.springframework.context.ApplicationContext;

/**
 * @author hrishi
 *
 */
public class SecurityFactory {
	
	private static ApplicationContext securityContext;
	
	private static final String SECURITY_SERVICE = "appSecurityService";
	
	private SecurityFactory(){
		//A Factory Class
	}

	public static void setSecurityContext(ApplicationContext securityContext) {
		SecurityFactory.securityContext = securityContext;
	}

	public static Object getAppSecurityService(){
		return securityContext.getBean(SECURITY_SERVICE);
	}
}