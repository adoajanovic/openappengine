/**
 * 
 */
package com.openappengine.facade.ui.proxy;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.openappengine.facade.ui.resolver.ValueResolver;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author hrishikesh.joshi
 * Dec 26, 2011
 */
public class ValueRefResolverInterceptor implements MethodInterceptor {
	
	protected final Logger logger = Logger.getLogger(getClass()); 

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		logger.info("Intercepting the method");
		if(method.getName().equals("getValue")) {
			//TODO - Get the value from the Screen Context if available.
			
			ValueResolver valueResolver;
		}
		return methodProxy.invokeSuper(object, args);
	}

}
