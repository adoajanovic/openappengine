/**
 * 
 */
package com.openappengine.gui.engine.core.widget.meta;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Feb 26, 2012
 */
public class WidgetMetadataConfigurationReader {
	
	private String[] locations;

	public void setLocations(String[] locations) {
		this.locations = locations;
	}
	
	public List<WidgetMetadata> readWidgetMetadata() {
		List<WidgetMetadata> list = new ArrayList<WidgetMetadata>();
		if(locations != null) {
			for (String location : locations) {
				InputStream inputStream = WidgetMetadataConfigurationReader.class.getClassLoader().getResourceAsStream(location);
				Assert.notNull(inputStream, "File : " + location + " could not be read.");
				WidgetMetadata widgetMetadata = readWidgetMetadata(location, inputStream);
				list.add(widgetMetadata);
			}
		}
		return list;
	}

	/**
	 * @param location
	 * @param inputStream
	 * @param widgetMetaDataImpl
	 */
	private WidgetMetadata readWidgetMetadata(String location, InputStream inputStream) {
		WidgetMetadataImpl widgetMetaDataImpl = new WidgetMetadataImpl();
		Document document = createXmlDocument(location, inputStream);
		if(document != null) {
			Element documentElement = document.getDocumentElement();
			String attrWidgetName = documentElement.getAttribute("name");
			if(StringUtils.isEmpty(attrWidgetName)) {
				throw new IllegalArgumentException("Widget Name cannot be blank.");
			}
			
			widgetMetaDataImpl.setWidgetName(attrWidgetName);	
			
			List<Element> parameterElements = DomUtils.getChildElementsByTagName(documentElement, "parameter");
			if(parameterElements != null) {
				for (Element paramEle : parameterElements) {
					WidgetParameter parameter = doReadWidgetParameter(paramEle);
					widgetMetaDataImpl.getWidgetParameters().add(parameter);
				}
			}	 
		}
		
		return widgetMetaDataImpl;
	}

	/**
	 * @param paramEle
	 * @return
	 */
	private WidgetParameter doReadWidgetParameter(Element paramEle) {
		WidgetParameter parameter = new WidgetParameter();
		
		String attrName = paramEle.getAttribute("name");
		Assert.notNull(attrName, "Parameter 'name' cannot be null. Exception encountered while reading widget.");
		parameter.setName(attrName);
		
		String attrMandatory = paramEle.getAttribute("mandatory");
		if(StringUtils.isEmpty(attrMandatory)) {
			parameter.setMandatory(false);	
		} else {
			parameter.setMandatory(BooleanUtils.toBoolean(attrMandatory));
		}
		return parameter;
	}

	/**
	 * @param location
	 * @param inputStream
	 */
	private Document createXmlDocument(String location, InputStream inputStream) {
		Document document;
		try {
			document = UtilXml.readXmlDocument(inputStream);
		} catch (SAXException e) {
			throw new IllegalArgumentException("Malformed Xml Structure found at location " + location);
		} catch (Exception e) {
			throw new IllegalArgumentException("Exception encountered while reading from location " + location);
		}
		return document;
	}

}
