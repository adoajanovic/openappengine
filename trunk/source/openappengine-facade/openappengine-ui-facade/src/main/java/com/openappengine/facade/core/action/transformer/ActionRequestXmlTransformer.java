/**
 * 
 */
package com.openappengine.facade.core.action.transformer;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.transformer.Transformer;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public interface ActionRequestXmlTransformer extends Transformer<AbstractExecutableComponent,ActionRequestXml> {
	
	/**
	 * @param executableComponent
	 * @return
	 */
	ActionRequestXml transform(AbstractExecutableComponent executableComponent);
}
