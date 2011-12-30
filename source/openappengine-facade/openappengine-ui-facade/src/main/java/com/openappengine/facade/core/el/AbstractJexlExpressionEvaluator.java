/**
 * 
 */
package com.openappengine.facade.core.el;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

import com.openappengine.facade.core.context.ScreenApplicationContext;
import com.openappengine.facade.ui.context.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public abstract class AbstractJexlExpressionEvaluator implements ExpressionEvaluator {
	
	private ScreenApplicationContext context;

	@Override
	public void setScreenApplicationContext(ScreenApplicationContext context) {
		this.context = context;
	}

	@Override
	public abstract Object evaluate(String expression);

	protected ScreenApplicationContext getContext() {
		return context;
	}
	
	protected JexlContext createJexlContext() {
		JexlContext jc = JexlHelper.createContext();
		
		Map<String, Object> vars = new HashMap<String, Object>();
		Map<String, Variable> screenVariables = context.getUIRoot().getScreenVariables();
		Collection<Variable> variables = screenVariables.values();
		if(variables != null) {
			for (Variable variable : variables) {
				vars.put(variable.getName(), variable.getValue());
			}
		}
		
		jc.getVars().putAll(vars);
		return jc;
	}
	
}
