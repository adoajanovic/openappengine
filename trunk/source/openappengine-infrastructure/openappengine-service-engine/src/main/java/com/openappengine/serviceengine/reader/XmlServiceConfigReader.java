/**
 * 
 */
package com.openappengine.serviceengine.reader;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ms.openapps.util.UtilLogger;
import com.ms.openapps.util.UtilString;
import com.ms.openapps.util.UtilXml;
import com.openappengine.serviceengine.model.GenericServiceModel;
import com.openappengine.serviceengine.model.ModelServiceFactory;

/**
 * @author hrishi
 * 
 */
public class XmlServiceConfigReader {

	private static final String ELEMENT_SERVICE_DEFINITION = "ServiceDefinition";

	private static final String ELEMENT_SERVICE_NAME = "ServiceName";

	private static final String ELEMENT_SERVICE_CLASS = "ServiceClass";

	private static final String ELEMENT_SERVICE_AGGREGATE_ROOT = "AggregateRoot";

	private final UtilLogger logger = new UtilLogger(getClass());

	private Document loadServiceDefinitionDocument(String serviceDefLocation) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		URL urlConfig = classLoader.getResource(serviceDefLocation);
		Document configXmlDocument = null;
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			configXmlDocument = documentBuilder.parse(new File(urlConfig
					.toURI()));
		} catch (Exception e) {
			logger.logError("Exception while reading the config Xml", e);
		}
		return configXmlDocument;
	}

	public void loadGenericModelServices(String serviceDefLocation) {
		Document document = loadServiceDefinitionDocument(serviceDefLocation);
		if (document != null) {
			List<? extends Element> childElementList = UtilXml.childElementList(document.getDocumentElement(),ELEMENT_SERVICE_DEFINITION);
			if (childElementList != null && childElementList.size() != 0) {
				for (Element element : childElementList) {
					GenericServiceModel genericServiceModel = getGenericServiceModel(element);
					ModelServiceFactory.addXmlServiceDefinition(
							genericServiceModel.getServiceName(),
							genericServiceModel);
				}
			}
		}
	}

	private GenericServiceModel getGenericServiceModel(Element e) {
		if (e == null) {
			return null;
		}
		String serviceName = e.getAttribute(ELEMENT_SERVICE_NAME);
		if (UtilString.isEmptyOrBlank(serviceName)) {
			throw new XmlServiceConfigException("Element "
					+ ELEMENT_SERVICE_NAME + " cannot be null or blank");
		}

		String serviceClass = e.getAttribute(ELEMENT_SERVICE_CLASS);
		if (UtilString.isEmptyOrBlank(serviceClass)) {
			throw new XmlServiceConfigException("Element "
					+ ELEMENT_SERVICE_CLASS + " cannot be null or blank");
		}

		String aggregateRoot = e.getAttribute(ELEMENT_SERVICE_AGGREGATE_ROOT);
		if (UtilString.isEmptyOrBlank(aggregateRoot)) {
			throw new XmlServiceConfigException("Element "
					+ ELEMENT_SERVICE_AGGREGATE_ROOT
					+ " cannot be null or blank");
		}

		GenericServiceModel genericServiceModel = new GenericServiceModel(
				serviceName, serviceClass,aggregateRoot);
		return genericServiceModel;
	}

}
