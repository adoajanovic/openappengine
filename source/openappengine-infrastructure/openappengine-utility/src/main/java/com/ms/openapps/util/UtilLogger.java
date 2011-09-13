/**
 * 
 */
package com.ms.openapps.util;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class UtilLogger {
	
	private Logger logger;

	public UtilLogger(Class<?> clz) {
		this.logger = Logger.getLogger(clz);
	}
	
	protected UtilLogger() {
	}
	
	public void logError(Object message) {
		logger.error(message);
	}
	
	public void logError(Object message,Throwable t) {
		logger.error(message, t);
	}
	
	public void logInfo(Object message) {
		logger.info(message);
	}
	
	public void logInfo(Object message,Throwable t) {
		logger.info(message, t);
	}
	
	public void logDebug(Object message) {
		logger.debug(message);
	}
	
	public void logDebug(Object message,Throwable t) {
		logger.debug(message, t);
	}
	
}
