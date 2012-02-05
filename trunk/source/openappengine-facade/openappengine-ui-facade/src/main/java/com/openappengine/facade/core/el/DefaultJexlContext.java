/**
 * 
 */
package com.openappengine.facade.core.el;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;
import org.apache.commons.lang.StringUtils;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.variable.Variable;

/**
 * @author hrishi
 * since Jan 3, 2012
 */
public class DefaultJexlContext implements ELContext {
	
	private Map<String,Variable> resolvedContextVariables = new ConcurrentHashMap<String, Variable>();
	
	private static final JexlContext jexlContext;
	
	static {
		jexlContext = JexlHelper.createContext();
	}
	
	@Override
	public Map<String,Variable> getElContextVariables() {
		return resolvedContextVariables;
	}

	@Override
	public Object evaluateELExpression(String expression) {
		try {
			Expression e = ExpressionFactory.createExpression(expression);
			Object result = e.evaluate(jexlContext);
			return result;
		} catch (Exception e1) {
			//TODO
		}
		return null;
	}

	@Override
	public void registerELContextVariable(String name,Object value) {
		Variable var = new Variable();
		var.setName(name);
		var.setValue(value);
		resolvedContextVariables.put(name, var);
	}
	
	public Object getVariable(String name) {
		if(StringUtils.isEmpty(name)) {
			return null;
		}
		
		if(resolvedContextVariables.containsKey(name)) {
			Variable variable = resolvedContextVariables.get(name);
			return variable.getValue();
		}
		return null;
	}
	
	public <T> T getVariable(String name,Class<T> t) {
		Object variable = getVariable(name);
		return (T)variable;
	}

	@Override
	public void removeELContextVariable(String name) {
		if(!resolvedContextVariables.containsKey(name)) {
			return;
		}
		
		resolvedContextVariables.remove(name);
	}
}
