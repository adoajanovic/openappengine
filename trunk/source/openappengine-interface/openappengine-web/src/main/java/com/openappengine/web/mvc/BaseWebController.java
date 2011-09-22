/**
 * 
 */
package com.openappengine.web.mvc;

import org.w3c.dom.Document;

import com.openappengine.messages.api.MessagePayload;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.serviceengine.facade.ServiceFacade;
import com.openappengine.serviceengine.message.ServiceRequestMessageWrapper;
import com.openappengine.serviceengine.message.ServiceResponseMessageWrapper;

/**
 * @author hrishi
 *
 */
public class BaseWebController {
	
	/**
	 * @param requestPayload
	 * @param serviceName TODO
	 * @return TODO
	 */
	protected ServiceResponseMessageWrapper callServiceFacade(
			MessagePayload requestPayload, String serviceName) {
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		try {
			Document requestMarshalledObject = oxmMapper.marshalObject(requestPayload);
			ServiceRequestMessageWrapper requestMessageWrapper = new ServiceRequestMessageWrapper(requestMarshalledObject);
			ServiceResponseMessageWrapper result = ServiceFacade.callXmlService(
					serviceName, requestMessageWrapper);
			return result;
		} catch (OxmMappingException e) {
			//TODO
			//addErrorMessage("Action Failed : Create Sales Order.");
		}
		return null;
	}
	
	
	/**
	 * @return {@link OxmMapper}
	 */
	protected IOxmMapper getOxmMapper() {
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		return oxmMapper;
	}

}
