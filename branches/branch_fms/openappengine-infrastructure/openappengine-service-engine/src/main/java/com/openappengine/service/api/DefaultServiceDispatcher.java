package com.openappengine.service.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.openappengine.service.model.ModelService;
import com.openappengine.service.model.ModelServiceFactory;
import com.openappengine.service.model.ModelServiceParameter;

/**
 * 
 * @author hrishikesh.joshi
 * @since  Mar 14, 2012
 *
 */
public class DefaultServiceDispatcher implements ServiceDispatcher {
	
	private ModelServiceFactory factory;
	
	private ServiceEngine serviceEngine;

	@Override
	public Map<String, Object> runSync(String serviceName,Map<String, Object> context) throws ServiceException {
		if(StringUtils.isEmpty(serviceName)) {
			throw new IllegalArgumentException("Service Name is required to invoke the ServiceEngine.");
		}
		
		ModelService modelService = factory.getModelService(serviceName);
		if(modelService == null) {
			throw new ServiceDispatcherException("Service not found by name :" + serviceName);
		}
		
		List<ModelServiceParameter> parameters = modelService.getInParams();
		
		Map<String, Object> inputMap = new HashMap<String, Object>();
		
		if(parameters != null) {
			for (ModelServiceParameter parameter : parameters) {
				String paramName = parameter.getName();
				Object paramVal = context.get(paramName);
				if(BooleanUtils.isFalse(parameter.getOptional()) && paramVal == null) {
					throw new ServiceException("Service Parameter :" + paramName + " is required.!! This cannot be null");
				}
				
				if(paramVal != null) {
					if(!parameter.getType().isAssignableFrom(paramVal.getClass())) {
						throw new ServiceException("Service Parameter :"
								+ paramName + " is of type "
								+ parameter.getType().getName()
								+ ". But the parameter is of type "
								+ paramVal.getClass().getName() + ".");
					}
				}
			
				inputMap.put(paramName, paramVal);
			}
		}
		
		Map<String, Object> runSyncResult = serviceEngine.runSync(modelService, inputMap);
		
		return runSyncResult;
	}

	@Override
	public void runSyncIgnoreResult(String serviceName,Map<String, Object> context) throws ServiceException {
		runSync(serviceName, context);
	}

	protected ModelServiceFactory getFactory() {
		return factory;
	}

	public void setFactory(ModelServiceFactory factory) {
		this.factory = factory;
	}

	protected ServiceEngine getServiceEngine() {
		return serviceEngine;
	}

	public void setServiceEngine(ServiceEngine serviceEngine) {
		this.serviceEngine = serviceEngine;
	}

}
