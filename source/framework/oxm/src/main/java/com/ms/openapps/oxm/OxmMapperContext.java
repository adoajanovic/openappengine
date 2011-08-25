/**
 * 
 */
package com.ms.openapps.oxm;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishi
 *
 */
public class OxmMapperContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		OxmMapperContext.applicationContext = applicationContext;
	}

	public static IOxmMapper getOxmMapper() {
		return (IOxmMapper) applicationContext.getBean(OxmConstants.OX_MAPPER);
	}

}
