/**
 * 
 */
package com.openappengine.gui.engine.core.transformer;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.gui.engine.core.request.transformer.ExternalRequestParamsXml;
import com.openappengine.gui.engine.core.xml.transformer.StringConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Feb 10, 2012
 *
 */
public class ExternalRequestParamsTransformer implements Transformer<HttpServletRequest, ExternalRequestParamsXml> {

	@Override
	public ExternalRequestParamsXml transform(HttpServletRequest request) {
		Document xmlDocument = UtilXml.makeEmptyXmlDocument("external-params");
				
		Map parameterMap = request.getParameterMap();
		if(parameterMap != null) {
			Set<String> keySet = parameterMap.keySet();
			for (String key : keySet) {
				String[] value = (String[]) parameterMap.get(key);
				Element requestParam = xmlDocument.createElement("external-param");
				requestParam.setNodeValue(value[0]);
			}
		}
		
		return new ExternalRequestParamsXml(xmlDocument);
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringConverter converter) {
		// TODO Auto-generated method stub
	}

	

}
