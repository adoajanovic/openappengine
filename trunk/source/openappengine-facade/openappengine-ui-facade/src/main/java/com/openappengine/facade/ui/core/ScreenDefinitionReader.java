package com.openappengine.facade.ui.core;

import org.springframework.core.io.Resource;

/**
 * @author hrishi
 * since Dec 28, 2011
 */
public interface ScreenDefinitionReader {
	
	/**
	 * Load Screen Definition from the specified XML file.
	 * @param resource
	 */
	void loadScreenDefinition(Resource resource);
	
}
