/**
 *  This class is the lifecycle handler for Persistence using Jpa + Hibernate
 */
package com.ms.openapps.entity.lifecycle;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hrishi
 *
 */
public class JpaHibernatePersistenceLifeCycleHandler implements
		IPersistenceLifecycleHandler {
	
	protected  String sPersistenceConfigXml = "service-context.xml";

	protected ApplicationContext jpaApplicationContext;
	
	protected static Logger LOGGER = Logger.getLogger("JpaHibernatePersistenceLifeCycleHandler.class");
	
	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.lifecycle.IPersistenceLifecycleHandler#startUp()
	 */
	@Override
	public void startUp() {
		LOGGER.trace("Starting the Jpa Hibernate Persistence Unit");
		jpaApplicationContext = new ClassPathXmlApplicationContext(getsPersistenceConfigXml());
	}

	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.lifecycle.IPersistenceLifecycleHandler#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.ms.catv.persistence.lifecycle.IPersistenceLifecycleHandler#shutDown()
	 */
	@Override
	public void shutDown() {
		LOGGER.trace("Closing the Jpa Hibernate Persistence Unit");
		jpaApplicationContext = null;
	}

	/**
	 * @param sPersistenceConfigXml the sPersistenceConfigXml to set
	 */
	public void setsPersistenceConfigXml(String sPersistenceConfigXml) {
		this.sPersistenceConfigXml = sPersistenceConfigXml;
	}

	/**
	 * @return the sPersistenceConfigXml
	 */
	public String getsPersistenceConfigXml() {
		return sPersistenceConfigXml;
	}

	/**
	 * @param jpaApplicationContext the jpaApplicationContext to set
	 */
	public void setJpaApplicationContext(ApplicationContext jpaApplicationContext) {
		this.jpaApplicationContext = jpaApplicationContext;
	}

	/**
	 * @return the jpaApplicationContext
	 */
	public ApplicationContext getJpaApplicationContext() {
		return jpaApplicationContext;
	}

}
