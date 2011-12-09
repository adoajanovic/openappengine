/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 *
 */
public class EntityDefinitionReader {
	
	public List<EntityDefinition> readEntityDefinitions(String location) {
		if(StringUtils.isBlank(location)) {
			throw new EntityDefinitionReaderException("Loading EntityDefinitions failed; specified location cannot be blank.");
		}
		
		InputStream inputStream = getClass().getResourceAsStream(location);
		try {
			Document document = UtilXml.readXmlDocument(inputStream);
			List<? extends Element> entityElements = UtilXml.childElementList(document.getDocumentElement(), "entity");
			if(entityElements != null && !entityElements.isEmpty()) {
				for (Element entityElement : entityElements) {
					String name = UtilXml.readElementAttribute(entityElement, "name");
					String cls = UtilXml.readElementAttribute(entityElement, "class");
					String isDeleteable = UtilXml.readElementAttribute(entityElement, "is-deleteable");
				}
			}
		} catch (Exception e) {
			throw new EntityDefinitionReaderException("Exception encountered while reading from the classpath location : " + location);
		}
		
		return null;
	}

	protected FieldDefinition readFieldDefinition(Element fieldElement) {
		//TODO
		return null;
	}
}
