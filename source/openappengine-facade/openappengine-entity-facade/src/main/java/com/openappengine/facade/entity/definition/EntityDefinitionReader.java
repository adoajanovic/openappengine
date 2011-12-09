/**
 * 
 */
package com.openappengine.facade.entity.definition;

import java.io.InputStream;
import java.util.ArrayList;
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
		List<EntityDefinition> entityDefinitions = new ArrayList<EntityDefinition>();
		InputStream inputStream = getClass().getResourceAsStream(location);
		try {
			Document document = UtilXml.readXmlDocument(inputStream);
			List<? extends Element> entityElements = UtilXml.childElementList(document.getDocumentElement(), "entity");
			if(entityElements != null && !entityElements.isEmpty()) {
				for (Element entityElement : entityElements) {
					String name = UtilXml.readElementAttribute(entityElement, "name");
					String cls = UtilXml.readElementAttribute(entityElement, "class");
					String isDeleteable = UtilXml.readElementAttribute(entityElement, "is-deleteable");
					
					Class<?> entityClass = Class.forName(cls);
					if(entityClass == null) {
						throw new EntityDefinitionReaderException("EntityClass not found from : " + cls);			
					}
					
					EntityDefinition entityDefinition = new EntityDefinition();
					entityDefinition.setDeleteable(Boolean.getBoolean(isDeleteable));
					entityDefinition.setEntityClass(entityClass);
					entityDefinition.setEntityName(name);
					
					List<? extends Element> fieldElements = UtilXml.childElementList(entityElement, "field");
					if(fieldElements != null && !fieldElements.isEmpty()) {
						for (Element fieldElement : fieldElements) {
							FieldDefinition readFieldDefinition = readFieldDefinition(fieldElement);
						}
					}
					
					entityDefinitions.add(entityDefinition);
				}
			}
		} catch (Exception e) {
			throw new EntityDefinitionReaderException("Exception encountered while reading from the classpath location : " + location);
		}
		
		return entityDefinitions;
	}

	protected FieldDefinition readFieldDefinition(Element fieldElement) {
		FieldDefinition fieldDefinition = new FieldDefinition();
		String name = UtilXml.readElementAttribute(fieldElement, "name");
		String property = UtilXml.readElementAttribute(fieldElement, "property");
		String isPK = UtilXml.readElementAttribute(fieldElement, "is-pk");
		String isRequired = UtilXml.readElementAttribute(fieldElement, "is-required");
		String isUpdatable = UtilXml.readElementAttribute(fieldElement, "is-updatable");
		
		if(StringUtils.isBlank(name)) {
			throw new EntityDefinitionReaderException("Attribute name cannot be empty.");
		}
		fieldDefinition.setName(name);
		
		if(StringUtils.isBlank(property)) {
			throw new EntityDefinitionReaderException("Attribute name cannot be empty.");
		}
		fieldDefinition.setProperty(property);
		
		if(StringUtils.isBlank(isPK)) {
			fieldDefinition.setPk(false);
		} else {
			fieldDefinition.setPk(Boolean.getBoolean(isPK));
		}
		
		if(StringUtils.isBlank(isRequired)) {
			fieldDefinition.setRequired(false);
		} else {
			fieldDefinition.setRequired(Boolean.getBoolean(isRequired));
		}
		
		if(StringUtils.isBlank(isUpdatable)) {
			fieldDefinition.setUpdatable(false);
		} else {
			fieldDefinition.setUpdatable(Boolean.getBoolean(isUpdatable));
		}
		
		Element uiDescriptorElement = UtilXml.firstChildElement(fieldElement);
		if(uiDescriptorElement != null) {
			UIDescriptor uiDescriptor = new UIDescriptor(uiDescriptorElement);
			fieldDefinition.setUiDescriptor(uiDescriptor);
		} else {
			//TODO - Handle as a TextField.
		}
		
		return fieldDefinition;
	}
}
