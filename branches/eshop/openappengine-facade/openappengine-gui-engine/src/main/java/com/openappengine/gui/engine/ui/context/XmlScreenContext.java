/**
 * 
 */
package com.openappengine.gui.engine.ui.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class XmlScreenContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		XmlScreenContext.applicationContext = applicationContext;
	}

	
}
