/**
 * 
 */
package com.openappengine.entity.definition.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.entity.definition.Entity;
import com.openappengine.entity.definition.EntityDefinitionReaderException;
import com.openappengine.entity.definition.Field;
import com.openappengine.entity.definition.ui.UIField;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 * 
 */
public class EntityDefinitionReader {

    private String[] locations;
    
	private FieldTypeDefinitionReader fieldTypeDefinitionReader;
	
    /**
     * Init the Reader
     */
    public List<Entity> readEntityReaderDefinitions() {
	List<Entity> entityDefinitions = new ArrayList<Entity>();
	if (locations != null) {
	    for (String location : locations) {
		List<Entity> definitions = readEntityDefinitions(location);
		entityDefinitions.addAll(definitions);
	    }
	}
	return entityDefinitions;
    }

    public List<Entity> readEntityDefinitions(String location) {
	if (StringUtils.isBlank(location)) {
	    throw new EntityDefinitionReaderException(
		    "Loading EntityDefinitions failed; specified location cannot be blank.");
	}
	List<Entity> entityDefinitions = new ArrayList<Entity>();
	InputStream inputStream = getClass().getClassLoader()
		.getResourceAsStream(location);
	try {
	    Document document = UtilXml.readXmlDocument(inputStream);
	    List<? extends Element> entityElements = UtilXml.childElementList(
		    document.getDocumentElement(), "entity");
	    if (entityElements != null && !entityElements.isEmpty()) {
			for (Element entityElement : entityElements) {
				Entity entityDefinition = new Entity();
				
			    String name = UtilXml.readElementAttribute(entityElement,"name");
			    if (StringUtils.isEmpty(name)) {
			    	throw new EntityDefinitionReaderException("EntityName not found empty.");
			    }
			    entityDefinition.setEntityName(name);
			    
			    String cls = UtilXml.readElementAttribute(entityElement,"class");
			    if (StringUtils.isNotEmpty(cls)) {
			    	Class<?> entityClass = Class.forName(cls);
			    	if (entityClass == null) {
			    		throw new EntityDefinitionReaderException("EntityClass not found from : " + cls);
			    	}
			    	entityDefinition.setEntityClass(entityClass);
			    }
	
			    String isDeleteable = UtilXml.readElementAttribute(entityElement, "is-deleteable");
			    entityDefinition.setDeleteable(Boolean.parseBoolean(isDeleteable));
	
			    List<? extends Element> fieldElements = UtilXml.childElementList(entityElement, "field");
			    
			    if (fieldElements != null && !fieldElements.isEmpty()) {
					for (Element fieldElement : fieldElements) {
								Field fieldDefinition = readFieldDefinition(fieldElement);
								if (!entityDefinition.containsFieldDefinitionByFieldName(fieldDefinition.getName())
										&& !entityDefinition.containsFieldDefinitionByFieldRef(fieldDefinition)) {
									entityDefinition.addFieldDefinition(fieldDefinition);
								} else {
									throw new EntityDefinitionReaderException("FieldDefinition name =" + fieldDefinition.getName()
													+ " OR fieldDefinition property = "
													+ fieldDefinition.getProperty()
													+ " already configured !!");
								}
					}
			    }
			    
			    //Create Entity XML Document
			    setEntityDocumentXml(entityElement, entityDefinition);
			    
			    entityDefinitions.add(entityDefinition);
			}
	    }
	} catch (Exception e) {
	    throw new EntityDefinitionReaderException("Exception encountered while reading from the classpath location : "+ location,e);
	}
	
	return entityDefinitions;

    }

	/**
	 * @param entityElement
	 * @param entityDefinition
	 */
	private void setEntityDocumentXml(Element entityElement,
			Entity entityDefinition) {
		Document entityDoc = UtilXml.makeEmptyXmlDocument("entity");
		Node node = entityDoc.adoptNode(entityElement);
		entityDoc.getDocumentElement().appendChild(node);
		entityDefinition.setDocument(entityDoc);
	}

    protected Field readFieldDefinition(Element fieldElement) {
	Field fieldDefinition = new Field();
	
	String name = UtilXml.readElementAttribute(fieldElement, "name");
	if (StringUtils.isBlank(name)) {
	    throw new EntityDefinitionReaderException("Attribute name cannot be empty.");
	}
	fieldDefinition.setName(name);
	
	String type = UtilXml.readElementAttribute(fieldElement, "type");
	fieldDefinition.setType(type);

	String property = UtilXml.readElementAttribute(fieldElement, "property");
	if (StringUtils.isNotBlank(property)) {
	    fieldDefinition.setProperty(property);
	}
	
	String isPK = UtilXml.readElementAttribute(fieldElement, "is-pk");
	if (StringUtils.isBlank(isPK)) {
	    fieldDefinition.setPk(false);
	} else {
	    boolean pk = Boolean.parseBoolean(isPK);
	    if(pk) {
		String isAutoincrement = UtilXml.readElementAttribute(fieldElement,"is-autoincrement");
		boolean autoincrement = Boolean.parseBoolean(isAutoincrement);
		fieldDefinition.setAutoincrement(autoincrement);
		
		fieldDefinition.setRequired(true);
	    }
	    fieldDefinition.setPk(pk);
	}
	
	fieldDefinition.setAlphanumeric(true);
	
	String isNumeric = UtilXml.readElementAttribute(fieldElement,"is-numeric");
	boolean numeric = false;
	if (StringUtils.isBlank(isNumeric)) {
	    fieldDefinition.setRequired(false);
	} else {
		numeric = Boolean.parseBoolean(isNumeric);
	    fieldDefinition.setRequired(numeric);
	}
	
	//If Numeric Alpha -> False
    if(numeric) {
	    fieldDefinition.setAlpha(false);
	    fieldDefinition.setAlphanumeric(false);
    } else {
    	String isAlpha = UtilXml.readElementAttribute(fieldElement,"is-alpha");
    	
    	boolean alpha = false;
		if(!StringUtils.isEmpty(isAlpha)) {
			alpha = Boolean.parseBoolean(isAlpha);
			fieldDefinition.setAlpha(alpha);
		}
    	
    	if(alpha) {
    		fieldDefinition.setAlphanumeric(false);	
    	} else {
    		fieldDefinition.setAlphanumeric(true);
    	}
    }
	
	String isRequired = UtilXml.readElementAttribute(fieldElement,"is-required");
	boolean required = Boolean.parseBoolean(isRequired);
	if (StringUtils.isBlank(isRequired)) {
	    fieldDefinition.setRequired(false);
	} else {
	    fieldDefinition.setRequired(required);
	}
	
	if(required) {
	    fieldDefinition.setUpdatable(true);
	} else {
	    String isUpdatable = UtilXml.readElementAttribute(fieldElement,"is-updatable");
	    if (StringUtils.isBlank(isUpdatable)) {
		fieldDefinition.setUpdatable(false);
	    } else {
		fieldDefinition.setUpdatable(Boolean.parseBoolean(isUpdatable));
	    }
	}

	List<? extends Element> fieldTypeElementList = UtilXml.childElementList(fieldElement,"field-type");
	Element fieldTypeElement = fieldTypeElementList.get(0);
	
	UIField uiField;
	if (fieldTypeElement != null) {
	    uiField = getFieldTypeDefinitionReader().getUIField(fieldTypeElement);
	    fieldDefinition.setUiField(uiField);
	} else {
	    // TODO - Handle as a TextField.
	}

	return fieldDefinition;
    }

    public void setLocations(String[] locations) {
	this.locations = locations;
    }

	protected FieldTypeDefinitionReader getFieldTypeDefinitionReader() {
		return fieldTypeDefinitionReader;
	}

	public void setFieldTypeDefinitionReader(FieldTypeDefinitionReader fieldTypeDefinitionReader) {
		this.fieldTypeDefinitionReader = fieldTypeDefinitionReader;
	}
}
