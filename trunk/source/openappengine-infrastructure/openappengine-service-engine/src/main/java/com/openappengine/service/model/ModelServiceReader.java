/**
 * 
 */
package com.openappengine.service.model;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.openappengine.service.Service;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public class ModelServiceReader {
	

	public void initializeFactory(String[] locations,ModelServiceFactory factory) {
		if (locations != null) {
			for (String location : locations) {
				try {
					InputStream inputStream = getClass().getClassLoader().getResourceAsStream(location);
					Document document = UtilXml.readXmlDocument(inputStream);
					List<Element> serviceEles = DomUtils.getChildElementsByTagName(document.getDocumentElement(), "service");
					if(serviceEles != null) {
						for (Element serviceEle : serviceEles) {
							ModelService modelService = readModelService(serviceEle);
							factory.registerModelService(modelService);
						}
					}
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param serviceEle
	 * @return
	 */
	private ModelService readModelService(Element serviceEle) {
		ModelService modelService = new ModelService();
		String serviceName = UtilXml.readElementAttribute(serviceEle, "name");
		if(StringUtils.isEmpty(serviceName)) {
			throw new RuntimeException("Service Name cannot be empty.");
		}
		
		String className = UtilXml.readElementAttribute(serviceEle, "class");
		if(StringUtils.isEmpty(className)) {
			throw new RuntimeException("Service Class Name cannot be empty.");
		}
		
		Element descriptionEle = DomUtils.getChildElementByTagName(serviceEle, "description");
		if(descriptionEle != null) {
			modelService.setDescription(descriptionEle.getTextContent());
		}
		
		try {
			Class<?> serviceClass = Class.forName(className);
			if(Service.class.isAssignableFrom(serviceClass)) {
				modelService.setServiceClass((Class<? extends Service>) serviceClass);
				String invokeMethodStr = UtilXml.readElementAttribute(serviceEle, "invokeMethod");
				if(StringUtils.isEmpty(invokeMethodStr)) {
					throw new RuntimeException("Service Class " + className + " does not have an invoke method.");	
				}
				try {
					Method method = ClassUtils.getPublicMethod(serviceClass, invokeMethodStr, new Class[]{});
					modelService.setInvokeMethod(method);
				} catch (SecurityException e) {
					throw new RuntimeException("Security Exception encountered while calling Service Class " + className + " :: method :" + invokeMethodStr);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException("Service Class " + className + " does not have a method named " + invokeMethodStr);
				}
			} else {
				throw new RuntimeException("Service Class " + className + " does not extend from " + Service.class.getName());	
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Service Class " + className + " not found.");
		}
		
		List<Element> parameterEles = DomUtils.getChildElementsByTagName(serviceEle, "parameter");
		if(parameterEles != null) {
			List<ModelServiceParameter> parameters = new ArrayList<ModelServiceParameter>();
			for (Element parameterEle : parameterEles) {
				ModelServiceParameter parameter = new ModelServiceParameter();
				String name = UtilXml.readElementAttribute(parameterEle, "name");
				if(StringUtils.isEmpty(name)) {
					throw new RuntimeException("Parameter Name found blank for Service " + serviceName + ".");	
				}
				parameter.setName(name);
				
				String type = UtilXml.readElementAttribute(parameterEle, "type");
				if(StringUtils.isEmpty(type)) {
					type = "java.lang.String";	
				}
				try {
					Class<?> typeClass = Class.forName(type);
					parameter.setType(typeClass);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Parameter Type " + type + " not found.");	
				}
				
				String optionalStr = UtilXml.readElementAttribute(parameterEle, "optional");
				if(StringUtils.isEmpty(optionalStr)) {
					optionalStr = "false";
				}
				parameter.setOptional(BooleanUtils.toBoolean(optionalStr));
				
				String mode = UtilXml.readElementAttribute(parameterEle, "mode");
				if(StringUtils.isEmpty(mode)) { 
					throw new RuntimeException("Parameter Mode cannot be empty for Service " + serviceName + " :: Parameter : " + name);
				}
				parameter.setMode(mode);
				
				parameters.add(parameter);
			}
			modelService.setParameters(parameters);
		}
		return modelService;
	}

}
