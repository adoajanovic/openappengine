/**
 * 
 */
package com.ms.openapps.security.registry;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author hrishi
 *
 */
public class UserContextService {
	
	public static Map<String,LoggedInUser> loggedInUsersContext = new HashMap<String, LoggedInUser>();
	
	private static final Logger logger = Logger.getLogger("UserContextService");
	
	/**
	 *  Add LoggedInUser to the Context 
	 * @param sessionId
	 * @param loggedInUser
	 */
	public static void addLoggedInUser(String sessionId,LoggedInUser loggedInUser) {
		logger.debug("Adding New Logged-In User to the Registry ");
		logger.debug("Session Id :" + sessionId);
		logger.debug("Logged-In User :" + loggedInUser);
		
		loggedInUsersContext.put(sessionId, loggedInUser );
	}
	
	/**
	 * Get LoggedInUser Data for a given session key. 
	 * @param sessionId
	 * @return LoggedInUser
	 */
	public static LoggedInUser getLoggedInUser(String sessionId) {
		if(!loggedInUsersContext.containsKey(sessionId)) {
			return null;
		}
		return loggedInUsersContext.get(sessionId);
	}
	
	public static LoggedInUser removeLoggedInUser(String sessionId) {
		if(loggedInUsersContext.containsKey(sessionId)) {
			LoggedInUser user = loggedInUsersContext.remove(sessionId);
			logger.debug("Removing User :" +  user + " from UserContextRegistry for SessionId " + sessionId);
			return user;
		}
		logger.debug("No LoggedInUser found for " + sessionId);
		return null;
	}
	
}