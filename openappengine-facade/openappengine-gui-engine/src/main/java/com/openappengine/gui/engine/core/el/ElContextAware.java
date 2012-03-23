/**
 * 
 */
package com.openappengine.gui.engine.core.el;

import com.openappengine.gui.engine.core.ELContext;


/**
 * @author hrishi
 * since Jan 3, 2012
 */
public interface ElContextAware {

	/**
	 * @param elContext
	 */
	void setELContext(ELContext elContext);
}
