/**
 * 	Security Context Provider for the Spring Security 
 */
package com.ms.openapps.security.provider;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ms.openapps.security.loader.SecurityFactory;

/**
 * @author hrishi
 *
 */
public class SecurityContextProvider implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	private static final Logger LOGGER = Logger.getLogger(SecurityContextProvider.class.getName());
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.applicationContext = context;
	}
	
	public void initSecurityFactory(){
		LOGGER.info("Instantiating the Security Factory");
		SecurityFactory.setSecurityContext(applicationContext);
		LOGGER.info("Security Factory Instantiated");
	}

}
