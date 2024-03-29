/**
 * 
 */
package com.openappengine.entity.definition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.validator.DefaultEntityValidator;
import com.openappengine.entity.validator.EntityValidator;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishikesh.joshi
 *
 */
public class Entity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String entityName;
	
	private Class<?> entityClass;
	
	private boolean deleteable;
	
	private List<Field> fields = new ArrayList<Field>();
	
	private List<Field> pkFields = new ArrayList<Field>();
	
	private Map<String,Field> fieldDefinitionMap = new HashMap<String, Field>();
	
	private EntityValidator entityValidator = new DefaultEntityValidator(this);
	
	private Document document;
	
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
		processFieldDefinitions(fields);
	}
	
	public void addFieldDefinition(Field field) {
		if(field == null) {
			return;
		}
		fields.add(field);
		fieldDefinitionMap.put(field.getName(), field);
	}

	/**
	 * @param fields
	 */
	protected void processFieldDefinitions(List<Field> fields) {
		for (Field fieldDefinition : fields) {
			fieldDefinitionMap.put(fieldDefinition.getName(), fieldDefinition);
			addPKFields(fieldDefinition);
		}
	}

	/**
	 * @param fieldDefinition
	 */
	protected void addPKFields(Field fieldDefinition) {
		if(fieldDefinition.isPk()) {
			pkFields.add(fieldDefinition);
		}
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public boolean isDeleteable() {
		return deleteable;
	}

	public void setDeleteable(boolean deleteable) {
		this.deleteable = deleteable;
	}

	protected Map<String,Field> getFieldDefinitionMap() {
		return fieldDefinitionMap;
	}

	protected void setFieldDefinitionMap(Map<String,Field> fieldDefinitionMap) {
		this.fieldDefinitionMap = fieldDefinitionMap;
	}

	public Field getFieldDefinition(String fieldName) {
		return fieldDefinitionMap.get(fieldName);
	}
	
	public boolean containsFieldDefinitionByFieldName(String fieldName) {
		return fieldDefinitionMap.containsKey(fieldName);
	}
	
	public boolean containsFieldDefinitionByFieldRef(Field field) {
		if(fields != null) {
			
			if(StringUtils.isEmpty(field.getProperty())) {
				return false;
			}
			
			for (Field fieldDef : fields) {
				if(StringUtils.equals(fieldDef.getProperty(),field.getProperty())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<Field> getPKFields() {
		if(pkFields != null) {
			for (Field field : fields) {
				if(field.isPk()) {
					pkFields.add(field);
				}
			}
		}
		return pkFields;
	}

	public void setPrimaryKeyField(List<Field> primaryKeyFields) {
		this.pkFields = primaryKeyFields;
	}

	public EntityValidator getEntityValidator() {
		return entityValidator;
	}

	public void setEntityValidator(EntityValidator entityValidator) {
		this.entityValidator = entityValidator;
	}

	public Document getDocument() {
		if(document == null) {
			return null;
		}
		
		Element documentElement = document.getDocumentElement();
		Element entityEle = DomUtils.getChildElementByTagName(documentElement, "entity");
		
		Document retXmlDoc = UtilXml.makeEmptyXmlDocument(entityEle.getAttribute("name"));
		
		List<Element> fieldEles = DomUtils.getChildElementsByTagName(entityEle, "field");
		for (Element fieldEle : fieldEles) {
			String name = fieldEle.getAttribute("name");
			String type = fieldEle.getAttribute("type");
			
			Element namedFieldEl = retXmlDoc.createElement(name);
			namedFieldEl.setAttribute("type", type);
			retXmlDoc.getDocumentElement().appendChild(namedFieldEl);
		}
		
		return retXmlDoc;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
