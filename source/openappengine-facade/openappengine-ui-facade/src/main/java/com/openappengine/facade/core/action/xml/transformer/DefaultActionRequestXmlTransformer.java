/**
 * 
 */
package com.openappengine.facade.core.action.xml.transformer;

import java.lang.reflect.Field;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.facade.core.action.xml.ActionRequestXml;
import com.openappengine.facade.core.action.xml.DefaultActionRequestXml;
import com.openappengine.facade.core.component.executable.AbstractExecutableComponent;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 10, 2012
 */
public class DefaultActionRequestXmlTransformer implements ActionRequestXmlTransformer {

	@Override
	public ActionRequestXml transformActionRequest(AbstractExecutableComponent executableComponent) {
		Document xmlDocument = UtilXml.makeEmptyXmlDocument("action-request");
		if(executableComponent == null) {
			return new DefaultActionRequestXml(xmlDocument);
		}
		
		BeanWrapper executableBeanWrapper = new BeanWrapperImpl(executableComponent);
		Class<?> wrappedClazz = executableComponent.getClass();
		
		Field[] fields = wrappedClazz.getDeclaredFields();
		
		for (Field field : fields) {
			String fieldProperty = field.getName();
			if(executableBeanWrapper.isReadableProperty(fieldProperty)) {
				Element requestParamElement = xmlDocument.createElement("request-param");
				requestParamElement.setAttribute("name", fieldProperty);
				Object value = executableBeanWrapper.getPropertyValue(fieldProperty);
				//TODO use object to string converter.
				requestParamElement.setNodeValue(""+value);
			}
		}
		
		
		DefaultActionRequestXml actionRequestXml = new DefaultActionRequestXml(xmlDocument);
		return actionRequestXml;
	}

}
