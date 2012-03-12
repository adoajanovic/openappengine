/**
 * 
 */
package com.openappengine.entity.model;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.definition.EntityDefinitionReaderException;
import com.openappengine.utility.UtilXml;

/**
 * The default reader for reading Entity Definitions from the File Store. The
 * ModelReader initializes the factory which holds all the ModelEntity
 * instances.
 * 
 * @author hrishikesh.joshi
 * @since Mar 5, 2012
 * 
 */
public class ModelReader {
	
	protected static final Logger logger = Logger.getLogger(ModelReader.class);
	
	/**
	 * Init the Reader
	 */
	public List<ModelEntity> readModelEntities(String[] locations,ModelEntityFactory factory) {
		List<ModelEntity> entityDefinitions = new ArrayList<ModelEntity>();
		if (locations != null) {
			for (String location : locations) {
				if(logger.isTraceEnabled()) {
					logger.trace("Reading ModelEntity from Location " + location);
				}
				List<ModelEntity> definitions = readEntityDefinitions(location,factory);
				if (logger.isTraceEnabled()) {
					logger.trace("Completed reading ModelEntity from Location "
							+ location + ".\n Total Entities Read :"
							+ definitions != null ? definitions.size() : 0 
							+ ".\n");
				}
				entityDefinitions.addAll(definitions);
			}
		}
		return entityDefinitions;
	}

	public List<ModelEntity> readEntityDefinitions(String location,ModelEntityFactory factory) {
		if (StringUtils.isBlank(location)) {
			throw new EntityDefinitionReaderException(
					"Loading EntityDefinitions failed; specified location cannot be blank.");
		}
		List<ModelEntity> entityDefinitions = new ArrayList<ModelEntity>();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(location);
		
		try {
			Document document = UtilXml.readXmlDocument(inputStream);
			List<? extends Element> entityElements = UtilXml.childElementList(document.getDocumentElement(), "entity");
			
			if (entityElements != null && !entityElements.isEmpty()) {
				for (Element entityElement : entityElements) {
					ModelEntity modelEntity = new ModelEntity();

					String entityName = UtilXml.readElementAttribute(entityElement, "name");
					if (StringUtils.isEmpty(entityName)) {
						throw new EntityDefinitionReaderException("EntityName found empty.");
					}
					modelEntity.setEntityName(entityName);
					
					String tableName = UtilXml.readElementAttribute(entityElement, "table-name");
					if (StringUtils.isEmpty(tableName)) {
						throw new EntityDefinitionReaderException("Table Name found empty.");
					}
					modelEntity.setTableName(tableName);
					
					Boolean mutable = UtilXml.readBooleanElementAttribute(entityElement, "mutable");
					modelEntity.setMutable(mutable);

					//Read Fields
					List<? extends Element> fieldElements = UtilXml.childElementList(entityElement, "field");
					if (fieldElements != null && !fieldElements.isEmpty()) {
						for (Element fieldElement : fieldElements) {
							ModelField modelField = readFieldDefinition(fieldElement,modelEntity);
							modelEntity.addModelField(modelField);
						}
					}
					
					//Relationships.
					List<Element> relationshipEles = DomUtils.getChildElementsByTagName(entityElement, "relationship");
					if(relationshipEles != null) {
						List<ModelRelationship> modelRelationships = new ArrayList<ModelRelationship>();
						for (Element relationshipEle : relationshipEles) {
							ModelRelationship modelRelationship = new ModelRelationship();
							modelRelationship.setTitle(UtilXml.readElementAttribute(relationshipEle, "title"));
							modelRelationship.setType(UtilXml.readElementAttribute(relationshipEle, "type"));
							modelRelationship.setRelatedEntityName(UtilXml.readElementAttribute(relationshipEle, "related-entity-name"));
							
							List<Element> keyMapEles = DomUtils.getChildElementsByTagName(relationshipEle, "key-map");
							List<RelationshipKeyMap> relationshipKeyMaps = new ArrayList<RelationshipKeyMap>();
							if(keyMapEles != null) {
								for (Element keyMapEle : keyMapEles) {
									RelationshipKeyMap keyMap = new RelationshipKeyMap();
									keyMap.setFieldName(UtilXml.readElementAttribute(keyMapEle, "field-name"));
									keyMap.setRelatedFieldName(UtilXml.readElementAttribute(keyMapEle, "related-field-name"));
									relationshipKeyMaps.add(keyMap);
								}
							}
							modelRelationship.setRelatedFieldMap(relationshipKeyMaps);
							
							modelRelationships.add(modelRelationship);
						}
						
						modelEntity.setRelationships(modelRelationships);
					}
					
					factory.registerModelEntity(modelEntity);
					entityDefinitions.add(modelEntity);
				}
			}
		} catch (Exception e) {
			throw new EntityDefinitionReaderException("Exception encountered while reading from the classpath location : "
							+ location, e);
		}

		return entityDefinitions;

	}

	protected ModelField readFieldDefinition(Element fieldElement,ModelEntity modelEntity) {
		ModelField modelField = new ModelField(modelEntity);

		// Name
		String name = UtilXml.readElementAttribute(fieldElement, "name");
		if (StringUtils.isBlank(name)) {
			throw new EntityDefinitionReaderException("Attribute name cannot be empty.");
		}
		modelField.setName(name);
		
		// Column Name
		String columnName = UtilXml.readElementAttribute(fieldElement, "column-name");
		if (StringUtils.isBlank(columnName)) {
			throw new EntityDefinitionReaderException("Attribute column-name cannot be empty.");
		}
		modelField.setColumnName(columnName);

		// Type
		String type = UtilXml.readElementAttribute(fieldElement, "type");
		modelField.setType(type);

		// Is-PK Field.
		String isPK = UtilXml.readElementAttribute(fieldElement, "is-pk");
		if (StringUtils.isBlank(isPK)) {
			modelField.setPk(false);
		} else {
			boolean pk = BooleanUtils.toBoolean(isPK);
			modelField.setPk(pk);
		}
		
		// Is-Not Null Field.
		String isNotNull = UtilXml.readElementAttribute(fieldElement, "not-null");
		if (StringUtils.isBlank(isNotNull)) {
			modelField.setNotNull(false);
		} else {
			boolean notNull = BooleanUtils.toBoolean(isNotNull);
			modelField.setNotNull(notNull);
		}
		
		String isRequired = UtilXml.readElementAttribute(fieldElement, "required");
		if (StringUtils.isBlank(isRequired)) {
			modelField.setRequired(false);
		} else {
			boolean required = BooleanUtils.toBoolean(isRequired);
			modelField.setRequired(required);
		}

		return modelField;
	}

}

