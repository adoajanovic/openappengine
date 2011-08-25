/**
 * 
 */
package com.ms.openapps.entity.lifecycle;

/**
 * @author hrishi
 *
 */
public interface IPersistenceLifecycleHandler {
	
	/**
	 *Startup the persistence component
	 */
	public  void startUp();
	
	/**
	 *Init the persistence component
	 */
	public void init();
	
	/**
	 * Shutdown the persistence component
	 */
	public void shutDown();

}
