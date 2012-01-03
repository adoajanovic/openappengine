/**
 * 
 */
package com.openappengine.facade.core.resolve;

import org.springframework.util.Assert;

import com.openappengine.facade.core.ELContext;
import com.openappengine.facade.core.Resolver;
import com.openappengine.facade.core.el.ElContextAware;

/**
 * Resolve the variables from the ELContext.
 * 
 * @author hrishikesh.joshi
 * @since Jan 3, 2012
 */
public class ELContextVariableResolver implements Resolver,ElContextAware {
	
	private ELContext elContext;
	
	public ELContextVariableResolver(ELContext elContext) {
		super();
		setELContext(elContext);
	}

	@Override
	public void setELContext(ELContext elContext) {
		Assert.notNull(elContext, "EL Context cannot be null.");
		this.elContext = elContext;
	}

	@Override
	public Object resolve(String name) {
		return elContext.getVariable(name);
	}
	
}
