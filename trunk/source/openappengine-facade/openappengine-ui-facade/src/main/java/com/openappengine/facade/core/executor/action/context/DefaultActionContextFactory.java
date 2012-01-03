/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import java.util.Map;
import java.util.Set;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.executor.action.ActionHandlerWrapper;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContextFactory implements ActionContextFactory {

	@Override
	public ActionContext createActionContext(ActionHandler actionHandler, Map<String, Object> parameters, ELContext elContext) {
		ActionHandler wrappedActionHandler = mapActionParameters(actionHandler, parameters);
		ActionContext context = new DefaultActionContext(elContext,wrappedActionHandler);
		return context;
	}

	/**
	 * @param actionHandler
	 * @param parameters
	 * @return
	 */
	protected ActionHandler mapActionParameters(ActionHandler actionHandler, Map<String, Object> parameters) {
		ActionHandlerWrapper wrapper = new ActionHandlerWrapper(actionHandler);
		if(parameters != null) {
			Set<String> actionParams = parameters.keySet();
			for (String param : actionParams) {
				wrapper.put(param, parameters.get(param));
			}
		}
		return wrapper.getWrappedInstance();
	}
	

}
