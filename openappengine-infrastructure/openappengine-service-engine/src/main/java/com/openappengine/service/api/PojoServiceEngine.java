/**
 * 
 */
package com.openappengine.service.api;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.openappengine.service.Service;
import com.openappengine.service.model.ModelService;
import com.openappengine.service.model.ModelServiceParameter;

/**
 * The <code>PojoServiceEngine</code> is responsible for executing the 
 * POJO Services.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public class PojoServiceEngine implements ServiceEngine {

	@Override
	public Map<String, Object> runSync(ModelService modelService,Map<String, Object> context) throws ServiceException {
		Class<? extends Service> serviceClass = modelService.getServiceClass();
		Service service;
		try {
			service = serviceClass.newInstance();
		} catch (InstantiationException e) {
			throw new ServiceException("Could not initialize Service Class" + serviceClass.getName());
		} catch (IllegalAccessException e) {
			throw new ServiceException("Illegal Access to Service Class" + serviceClass.getName());
		}
		
		BeanWrapper beanWrapper = new BeanWrapperImpl(service);
		Set<String> paramNames = context.keySet();
		if(paramNames != null) {
			for (String paramName : paramNames) {
				beanWrapper.setPropertyValue(paramName, context.get(paramName));
			}
		}
		
		Method invokeMethod = modelService.getInvokeMethod();
		try {
			invokeMethod.invoke(beanWrapper.getWrappedInstance(), new Object[]{});
		} catch (Exception e) {
			throw new ServiceException("Exception encountered while invoking method " + modelService.getInvokeMethod().getName());
		}
		
		Map<String, Object> outputMap = new HashMap<String, Object>();
		
		if(!service.isError()) {
			List<ModelServiceParameter> outParams = modelService.getOutParams();
			if(outParams != null) {
				for (ModelServiceParameter outParameter : outParams) {
					String paramName = outParameter.getName();
					Object value = beanWrapper.getPropertyValue(paramName);
					if(BooleanUtils.isFalse(outParameter.getOptional())) {
						if(value == null) {
							throw new ServiceException("Out Parameter " + paramName + " is not optional, but a NULL value is returned.");
						}
					}
					outputMap.put(paramName, value);
				}
			}
		}
		//TODO - Service is in ERROR.
		
		return outputMap;
	}

	@Override
	public void runSyncIgnoreResult(ModelService modelService,Map<String, Object> context) throws ServiceException {
		runSync(modelService, context);
	}

}
