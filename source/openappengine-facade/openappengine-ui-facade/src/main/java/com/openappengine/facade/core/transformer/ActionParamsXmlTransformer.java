/**
 * 
 */
package com.openappengine.facade.core.transformer;

import com.openappengine.facade.core.action.xml.ActionParamsXml;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.facade.core.transformer.Transformer;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public interface ActionParamsXmlTransformer extends Transformer<AbstractExecutableComponent,ActionParamsXml> {
	
	/**
	 * @param executableComponent
	 * @return
	 */
	ActionParamsXml transform(AbstractExecutableComponent executableComponent);
}
