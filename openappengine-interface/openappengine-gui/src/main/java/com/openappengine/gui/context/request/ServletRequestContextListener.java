package com.openappengine.gui.context.request;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.springframework.web.context.request.RequestContextListener;

/**
 * Application Lifecycle Listener implementation class RequestContextListener
 *
 */
public class ServletRequestContextListener extends RequestContextListener {


	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre) {
    	super.requestDestroyed(sre);
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre) {
    	super.requestInitialized(sre);
    }
	
}
