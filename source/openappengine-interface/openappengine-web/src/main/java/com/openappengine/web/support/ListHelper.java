/**
 * 
 */
package com.openappengine.web.support;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.w3c.dom.Document;

import com.openappengine.messages.codes.Code;
import com.openappengine.messages.codes.GetCodesRequest;
import com.openappengine.messages.codes.GetCodesResponse;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.servicedef.ServiceNames;
import com.openappengine.serviceengine.message.ServiceResponseMessageWrapper;
import com.openappengine.web.mvc.BaseWebController;

/**
 * @author hrishi
 * 
 */
public class ListHelper extends BaseWebController {

	public List<SelectItem> getApplicationCodes(String codeType) throws OxmMappingException {
		List<SelectItem> codes = new ArrayList<SelectItem>();
		GetCodesRequest codesRequest = new GetCodesRequest(); 
		codesRequest.setCodeType(codeType);
		
		
		ServiceResponseMessageWrapper serviceResponseMessageWrapper = callServiceFacade(codesRequest, ServiceNames.SERVICE_GET_CODES);
		Document xmlResponse = serviceResponseMessageWrapper.getXmlResponse();
		GetCodesResponse codesResponseObj = (GetCodesResponse) getOxmMapper().unmarshal(xmlResponse);
		if(codesResponseObj != null) {
			List<Code> codesList = codesResponseObj.getCodes();
			if(codesList != null && !codesList.isEmpty()) {
				for(Code code : codesList) {
					SelectItem e = new SelectItem(code.getCodeValue(), code.getCodeLabel(), code.getCodeLabel());
					codes.add(e);
				}
			}
		}
		return codes;
	}
	
	/**
	 * @return Perishable Types
	 */
	public List<SelectItem> getYesNoSelect() {
		List<SelectItem> perishableTypes = new ArrayList<SelectItem>();
		perishableTypes.add(new SelectItem(Boolean.TRUE, "Yes"));
		perishableTypes.add(new SelectItem(Boolean.FALSE, "No"));
		return perishableTypes;
	}

}
