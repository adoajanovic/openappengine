/**
 * 
 */
package com.openappengine.facade.core.el;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishikesh.joshi
 * @since Dec 29, 2011
 */
public class AbstractJexlExpressionEvaluator implements ExpressionEvaluator {

	private ELContext elContext;
	
	private static final JexlContext jexlContext;
	
	static {
		jexlContext = JexlHelper.createContext();
	}

	@Override
	public Object evaluate(String expression) {
		return null;
	}

	protected JexlContext createJexlContext() {
		JexlContext jc = JexlHelper.createContext();
		
		Map<String, Object> vars = new HashMap<String, Object>();
		Map<String, Variable> screenVariables = elContext.getElContextVariables();
		Collection<Variable> variables = screenVariables.values();
		if(variables != null) {
			for (Variable variable : variables) {
				vars.put(variable.getName(), variable.getValue());
			}
		}
		
		jc.getVars().putAll(vars);
		return jc;
	}

	@Override
	public void setELContext(ELContext elContext) {
		this.elContext = elContext;
	}
	
}
