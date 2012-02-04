/**
 * 
 */
package com.openappengine.facade.core.executor.action.context;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.openappengine.facade.core.ActionRequest;
import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.component.ui.message.MessageContext;
import com.openappengine.facade.core.component.value.ValueFieldAware;
import com.openappengine.facade.core.executor.action.ActionContext;
import com.openappengine.facade.core.executor.action.ActionHandler;
import com.openappengine.facade.core.ext.ExternalContext;
import com.openappengine.facade.core.resolve.ELContextVariableResolver;

/**
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class DefaultActionContextFactory implements ActionContextFactory {
	
	private ELContextVariableResolver elContextVariableResolver;

	@Override
	public ActionContext createActionContext(ActionHandler actionHandler, ActionRequest actionRequest, ELContext elContext,ExternalContext externalContext,MessageContext messageContext) {
		resolveActionParameters(actionRequest);
		
		ActionContext context = new DefaultActionContext(externalContext,elContext,actionHandler,messageContext);
		elContextVariableResolver = new ELContextVariableResolver(elContext);
		return context;
	}

	/**
	 * @param parameters
	 * @return
	 */
	protected void resolveActionParameters(ActionRequest actionRequest) {
		Map<String, Object> parameters = actionRequest.getActionParameters();
		if(parameters != null) {
			Set<String> actionParams = parameters.keySet();
			for (String param : actionParams) {
				Object value = parameters.get(param);
				if(actionRequest instanceof ValueFieldAware) {
					String[] valueFields = ((ValueFieldAware)actionRequest).getValueFields();
					if(valueFields != null && Arrays.asList(valueFields).contains(param)) {
						value = elContextVariableResolver.resolve(param);
					}
					actionRequest.addActionParameter(param, value);
				}
			}
		}
	}

	public ELContextVariableResolver getElContextVariableResolver() {
		return elContextVariableResolver;
	}

	public void setElContextVariableResolver(ELContextVariableResolver elContextVariableResolver) {
		this.elContextVariableResolver = elContextVariableResolver;
	}
}
