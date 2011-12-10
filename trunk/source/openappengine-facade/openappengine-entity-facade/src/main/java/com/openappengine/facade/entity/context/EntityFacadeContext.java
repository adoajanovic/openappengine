/**
 * 
 */
package com.openappengine.facade.entity.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.openappengine.facade.entity.EntityFacade;
/**
 * @author hrishi
 *
 */
public class EntityFacadeContext implements ApplicationContextAware {

    private static ApplicationContext context;
    
    /* (non-Javadoc)
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext)
	    throws BeansException {
	EntityFacadeContext.context = applicationContext;
    }
    
    public static EntityFacade getEntityFacade() {
	return (EntityFacade) context.getBean("entityFacade");
    }

}
