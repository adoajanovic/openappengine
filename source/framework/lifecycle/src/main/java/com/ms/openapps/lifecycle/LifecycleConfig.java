/**
 * 
 */
package com.ms.openapps.lifecycle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ms.openapps.util.UtilLogger;
import com.ms.openapps.util.UtilString;
import com.ms.openapps.util.UtilXml;

/**
 * @author hrishi
 *
 */
public class LifecycleConfig {
	
	private static final String DEFINITION_LIFECYCLE_CONFIG = "LifecycleConfig.xml";
	
	private static final String LIFECYCLE_ATTR_ID = "id";
	
	private static final String LIFECYCLE_ATTR_EVENTHANDLER = "eventHandler";
	
	private static final String LIFECYCLE_ATTR_STARTUP_METHOD = "startup-method";
	
	private static final String LIFECYCLE_ATTR_SHUTDOWN_METHOD = "shutdown-method";
	
	private UtilLogger logger = new UtilLogger(getClass());
	
	public Component[] initLifecycleComponents() {
		Component[] components  = loadConfig();
		if(components == null || components.length == 0) {
			return null;
		}
		return components;
	}
	
	private Component[] loadConfig() {
		Document document = loadComponentDocument();
		List<Component> components = new ArrayList<Component>();
		
		if(document != null) {
			List<? extends Element> childElementList = UtilXml.childElementList(document.getDocumentElement());
		
			if(childElementList != null && childElementList.size() != 0) {
				for(Element element : childElementList) {
					Component component = getComponent(element);
					if(component != null) {
						components.add(component);
					}
				}
			}
			
		}
		return components.toArray(new Component[components.size()]);
	}
	
	private Component getComponent(Element e) {
		if(e == null) {
			return null;
		}
		
		String attrId = e.getAttribute(LIFECYCLE_ATTR_ID);
		if(UtilString.isEmptyOrBlank(attrId)) {
			throw new LifecycleConfigException("Attribute " + LIFECYCLE_ATTR_ID + " cannot be null or blank");
		}
		
		String attrHandler = e.getAttribute(LIFECYCLE_ATTR_EVENTHANDLER);
		if(UtilString.isEmptyOrBlank(attrHandler)) {
			throw new LifecycleConfigException("Attribute " + LIFECYCLE_ATTR_ID + " cannot be null or blank");
		}
		
		String attrStartupMethod = e.getAttribute(LIFECYCLE_ATTR_STARTUP_METHOD);
		if(UtilString.isEmptyOrBlank(attrStartupMethod)) {
			throw new LifecycleConfigException("Attribute " + LIFECYCLE_ATTR_ID + " cannot be null or blank");
		}
		
		String attrShutdownMethod = e.getAttribute(LIFECYCLE_ATTR_SHUTDOWN_METHOD);
		if(UtilString.isEmptyOrBlank(attrShutdownMethod)) {
			throw new LifecycleConfigException("Attribute " + LIFECYCLE_ATTR_ID + " cannot be null or blank");
		}
		
		Component c = new Component(attrId, attrHandler, attrStartupMethod, attrShutdownMethod);
		return c;
	}
	
	
	private Document loadComponentDocument() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		URL urlConfig = classLoader.getResource(DEFINITION_LIFECYCLE_CONFIG);
		Document configXmlDocument = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			configXmlDocument = documentBuilder.parse(new File(urlConfig.toURI()));
		} catch (Exception e) {
			logger.logError("Exception while reading the config Xml",e);
		}
		return configXmlDocument;
	}
	
}