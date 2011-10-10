/**
 * 
 */
package com.openappengine.bpm.procreader;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishi
 *
 */
public class ProcessReaderContext implements ApplicationContextAware {

	
	private static ApplicationContext context;
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ProcessReaderContext.context = applicationContext;
	}
	
	/**
	 * @return {@link IProcessDefReader}
	 */
	public IProcessDefReader getProcessDefReader() {
		return (IProcessDefReader) context.getBean("processDefReader");
	}

}
