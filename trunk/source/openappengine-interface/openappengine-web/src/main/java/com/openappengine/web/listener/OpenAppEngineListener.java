package com.openappengine.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ms.openapps.util.UtilLogger;
import com.openappengine.container.OpenAppEngineLifecycleHandler;

/**
 * Application Lifecycle Listener implementation class OpenAppEngineListener
 *
 */
public final class OpenAppEngineListener implements ServletContextListener {
	
	private final UtilLogger logger = new UtilLogger(getClass());
	private final OpenAppEngineLifecycleHandler lifecycleHandler;

    /**
     * Default constructor. 
     */
    public OpenAppEngineListener() {
    	lifecycleHandler = new OpenAppEngineLifecycleHandler();
    	logger.logInfo("Initialized OpenAppEngineListener");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    	logger.logInfo("Booting up OpenAppEngine Components");
    	lifecycleHandler.startup();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	logger.logInfo("Shutting Down OpenAppEngine Components");
    	lifecycleHandler.shutdown();
    }
	
}
