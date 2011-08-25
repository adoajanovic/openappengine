/**
 * 
 */
package com.ms.openapps.appflow.flow.engine;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author hrishi
 *
 */
public class WorkflowServiceContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	private static final String BEAN_WORKFLOW_ENGINE = "workflowEngine";
	
	private static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}
	
	public static WorkflowEngine getWorkflowEngine() {
		return (WorkflowEngine) getBean(BEAN_WORKFLOW_ENGINE);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}

}
