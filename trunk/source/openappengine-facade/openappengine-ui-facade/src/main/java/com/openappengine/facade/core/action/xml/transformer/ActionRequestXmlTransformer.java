/**
 * 
 */
package com.openappengine.facade.core.action.xml.transformer;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public interface ActionRequestXmlTransformer {
	
	/**
	 * @param executableComponent
	 * @return
	 */
	ActionRequestXml transformActionRequest(AbstractExecutableComponent executableComponent);
}
