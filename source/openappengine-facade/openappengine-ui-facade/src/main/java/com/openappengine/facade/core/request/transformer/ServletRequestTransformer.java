/**
 * 
 */
package com.openappengine.facade.core.request.transformer;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.facade.core.transformer.Transformer;
import com.openappengine.facade.core.xml.transformer.StringTypeConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Feb 10, 2012
 *
 */
public class ServletRequestTransformer implements Transformer<HttpServletRequest, Document> {

	@Override
	public Document transform(HttpServletRequest request) {
		Document xmlDocument = UtilXml.makeEmptyXmlDocument("request-params");
		if(request == null) {
			return xmlDocument;
		}
		
		Map parameterMap = request.getParameterMap();
		if(parameterMap != null) {
			Set<String> keySet = parameterMap.keySet();
			for (String key : keySet) {
				String[] value = (String[]) parameterMap.get(key);
				Element requestParam = xmlDocument.createElement("request-param");
				requestParam.setNodeValue(value[0]);
			}
		}
		
		return xmlDocument;
	}

	@Override
	public void registerCustomConverters(Class<?> forClass,StringTypeConverter converter) {
		// TODO Auto-generated method stub
	}

	

}
