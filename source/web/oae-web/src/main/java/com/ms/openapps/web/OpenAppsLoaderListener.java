package com.ms.openapps.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ms.openapps.lifecycle.OpenAppsLifecycleHandler;

/**
 * Application Lifecycle Listener implementation class OpenAppsLoaderListener
 *
 */
public class OpenAppsLoaderListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public OpenAppsLoaderListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce) {
    	OpenAppsLifecycleHandler appsLifecycleHandler = new OpenAppsLifecycleHandler();
    	appsLifecycleHandler.startup();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce) {
    	OpenAppsLifecycleHandler appsLifecycleHandler = new OpenAppsLifecycleHandler();
    	appsLifecycleHandler.shutdown();
    }
	
}
