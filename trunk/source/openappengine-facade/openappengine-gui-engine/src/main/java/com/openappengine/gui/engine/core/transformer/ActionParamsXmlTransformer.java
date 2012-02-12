/**
 * 
 */
package com.openappengine.gui.engine.core.transformer;

import com.openappengine.gui.engine.core.action.xml.ActionParamsXml;
import com.openappengine.gui.engine.core.component.executable.AbstractExecutableComponent;
import com.openappengine.gui.engine.core.transformer.Transformer;

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
