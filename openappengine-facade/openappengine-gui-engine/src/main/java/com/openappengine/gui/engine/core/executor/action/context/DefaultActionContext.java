/**
 * 
 */
package com.openappengine.gui.engine.core.executor.action.context;

import com.openappengine.gui.engine.core.ELContext;
import com.openappengine.gui.engine.core.component.ui.message.MessageContext;
import com.openappengine.gui.engine.core.executor.action.ActionHandler;
import com.openappengine.gui.engine.core.ext.ExternalContext;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContext extends AbstractActionContext {

	public DefaultActionContext(ExternalContext externalContext,ELContext elContext,MessageContext messageContext) {
		super(externalContext, elContext,messageContext);
	}

}
