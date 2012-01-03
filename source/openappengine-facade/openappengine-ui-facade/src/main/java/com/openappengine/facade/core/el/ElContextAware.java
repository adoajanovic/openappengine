/**
 * 
 */
package com.openappengine.facade.core.el;

import com.openappengine.facade.core.ELContext;


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
