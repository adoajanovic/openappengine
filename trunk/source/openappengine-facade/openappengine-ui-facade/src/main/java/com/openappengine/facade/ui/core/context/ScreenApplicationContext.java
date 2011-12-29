/**
 * 
 */
package com.openappengine.facade.ui.core.context;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;

import com.openappengine.facade.ui.core.UIRoot;
import com.openappengine.facade.ui.fsm.Transition;

/**
 * The Screen Application Context holds all the infrastructure dependencies related
 * to the Screen Reading,Rendering and Action Handling.  
 * 
 * @author hrishi
 * since Dec 29, 2011
 */
public interface ScreenApplicationContext {
	
	/**
	 * Get the Resource from which the current Screen was loaded.
	 * @return
	 */
	Resource getResource();
	
	/**
	 * Get The UIRoot of this context.
	 * @return
	 */
	UIRoot getUIRoot();
	
	/**
	 * Get the request parameters.
	 * @return
	 */
	Map<String, Object> getRequestParameters();

}
