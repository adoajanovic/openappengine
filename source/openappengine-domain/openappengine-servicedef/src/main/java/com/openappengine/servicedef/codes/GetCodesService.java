/**
 * 
 */
package com.openappengine.servicedef.codes;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import com.openappengine.domain.model.CoCodeMaster;
import com.openappengine.domain.model.CoCodeType;
import com.openappengine.messages.codes.Code;
import com.openappengine.messages.codes.GetCodesRequest;
import com.openappengine.messages.codes.GetCodesResponse;
import com.openappengine.oxm.IOxmMapper;
import com.openappengine.oxm.OxmMapperContext;
import com.openappengine.oxm.OxmMappingException;
import com.openappengine.repository.model.GenericEntity;
import com.openappengine.serviceengine.ServiceUtil;
import com.openappengine.serviceengine.context.DispatchContext;
import com.openappengine.serviceengine.definition.GenericServiceDef;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * 
 */
public class GetCodesService extends GenericServiceDef {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ms.openapps.servicedef.api.IServiceDef#performProcessing(com.ms.openapps
	 * .service.context.DispatchContext, org.w3c.dom.Document)
	 */
	public Document performProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		Document responseDoc = UtilXml.makeEmptyXmlDocument("GetCodesResponse");
		GetCodesResponse getCodesResponse = new GetCodesResponse();
		IOxmMapper oxmMapper = OxmMapperContext.getOxmMapper();
		GetCodesRequest getCodesRequest;

		try {
			getCodesRequest = (GetCodesRequest) oxmMapper.unmarshal(requestDoc);
		} catch (OxmMappingException e) {
			return ServiceUtil
					.returnError(responseDoc,
							"Unable to unmarshal the request Xml for GetCodesRequest Xml");
		}

		if (getCodesRequest == null) {
			return ServiceUtil.returnError(responseDoc,
					"Unmarshalled request object either null or empty.");
		}

		final String codeType = getCodesRequest.getCodeType();

		if (ApplicationCodeFactory.containsCode(codeType)) {
			responseDoc = ApplicationCodeFactory.getCode(codeType);
		} else { //Fetch code from DB
			List<GenericEntity> list = getGenericRepository().findByNamedParam(" from CoCodeType where ctCodeTypeValue = :codeType", "codeType", codeType);
			if (list != null && !list.isEmpty()) {
				CoCodeType coCodeType = (CoCodeType) list.get(0);
				List<CoCodeMaster> coCodeMasters = coCodeType
						.getCoCodeMasters();
				if (coCodeMasters != null) {
					List<Code> codes = new ArrayList<Code>();
					for (CoCodeMaster codeMaster : coCodeMasters) {
						Code code = new Code();
						code.setCodeId(codeMaster.getCmCodeMasterId());
						code.setCodeLabel(codeMaster.getCmCodeLabel());
						code.setCodeValue(codeMaster.getCmCodeValue());
						codes.add(code);
					}
					getCodesResponse.setCodes(codes);
					try {
						responseDoc = oxmMapper.marshalObject(getCodesResponse);
					} catch (OxmMappingException e) {
						e.printStackTrace();
						return ServiceUtil.returnError(requestDoc,
								"Response object cannot be marshalled.");
					}
					ApplicationCodeFactory.addCode(codeType, responseDoc);
				}
			}
		}
		return responseDoc;
	}

	@Override
	public Document performPreProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		return super.performPreProcessing(dispatchContext, requestDoc);
	}

	@Override
	public Document performPostProcessing(DispatchContext dispatchContext,
			Document requestDoc) {
		return super.performPostProcessing(dispatchContext, requestDoc);
	}

}
