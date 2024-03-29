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
	
	public List<WidgetMetadata> readWidgetMetadata(WidgetMetadataFactory widgetMetadataFactory) {
		List<WidgetMetadata> list = new ArrayList<WidgetMetadata>();
		
		if(locations == null || locations.length == 0) {
			return list;
		}
		
		for (String location : locations) {
			InputStream inputStream = WidgetMetadataConfigurationReader.class.getClassLoader().getResourceAsStream(location);
			Assert.notNull(inputStream, "File : " + location + " could not be read.");
			
			WidgetMetadata widgetMetadata = readWidgetMetadata(location, inputStream, widgetMetadataFactory);
			if(widgetMetadata != null) {
				list.add(widgetMetadata);
				widgetMetadataFactory.registerWidget(widgetMetadata);
			}
		}
		
		return list;
	}

	/**
	 * @param location
	 * @param inputStream
	 * @param factory TODO
	 * @param widgetMetaDataImpl
	 */
	private WidgetMetadata readWidgetMetadata(String location, InputStream inputStream, WidgetMetadataFactory factory) {
		Document document = createXmlDocument(location, inputStream);
		WidgetMetadata widgetMetadataImpl = null;
		if(document != null) {
			widgetMetadataImpl = doReadWidget(document.getDocumentElement(), factory);	
		}
		
		return widgetMetadataImpl;
	}

	/**
	 * @param factory TODO
	 * @param widgetMetaDataImpl
	 * @param document
	 */
	private WidgetMetadata doReadWidget(Element rootEle, WidgetMetadataFactory factory) {
		WidgetMetadataImpl widgetMetaDataImpl = new WidgetMetadataImpl();
		String attrWidgetName = rootEle.getAttribute("name");
		if(StringUtils.isEmpty(attrWidgetName)) {
			throw new IllegalArgumentException("Widget Name cannot be blank.");
		}
		widgetMetaDataImpl.setWidgetName(attrWidgetName);
		
		//Node Type
		String attrNodeType = rootEle.getAttribute("nodetype");
		if(StringUtils.isNotEmpty(attrNodeType)) {
			widgetMetaDataImpl.setNodeType(attrNodeType);
		}
		
		List<Element> parameterElements = DomUtils.getChildElementsByTagName(rootEle, "parameter");
		if(parameterElements != null) {
			for (Element paramEle : parameterElements) {
				WidgetParameter parameter = doReadWidgetParameter(paramEle);
				widgetMetaDataImpl.getWidgetParameters().add(parameter);
			}
		}
		
		
		//If Widget Has Children
		List<Element> childWidgetEles = DomUtils.getChildElementsByTagName(rootEle, "widget");
		if(childWidgetEles != null && !childWidgetEles.isEmpty()) {
			List<WidgetMetadata> childWidgets = new ArrayList<WidgetMetadata>();
			
			for (Element childWidgetEle : childWidgetEles) {
				String attrReferencedWidgetName = childWidgetEle.getAttribute("ref");
				if(StringUtils.isNotEmpty(attrReferencedWidgetName)) {
					widgetMetaDataImpl.getReferencedWidgets().add(attrReferencedWidgetName);
				} else {
					WidgetMetadata childWidgetMetadata = doReadWidget(childWidgetEle, factory);
					childWidgets.add(childWidgetMetadata);
				}
			}
			
			widgetMetaDataImpl.setChildWidgetsMetadata(childWidgets);
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
		
		String attrXPath = paramEle.getAttribute("path");
		if(StringUtils.isNotEmpty(attrXPath)) {
			parameter.setXpath(attrXPath);
		}
		
		String attrMandatory = paramEle.getAttribute("mandatory");
		if(StringUtils.isEmpty(attrMandatory)) {
			parameter.setMandatory(false);	
		} else {
			parameter.setMandatory(BooleanUtils.toBoolean(attrMandatory));
		}
		
		String attrDefault = paramEle.getAttribute("default");
		if(StringUtils.isNotEmpty(attrDefault)) {
			parameter.setDefaultValue(attrDefault);
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
