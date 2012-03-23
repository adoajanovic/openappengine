/**
 * 
 */
package com.openappengine.entity.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.openappengine.entity.delegator.Delegator;
import com.openappengine.entity.model.ModelEntity;
import com.openappengine.entity.model.ModelField;
import com.openappengine.utility.ObjectConverter;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 * since Mar 5, 2012
 */
public class ValueEntity extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	protected ValueEntity(){}

	//Create a new Value Entity.
	public static ValueEntity createValueEntity(ModelEntity modelEntity) {
		ValueEntity valueEntity = new ValueEntity();
		valueEntity.init(modelEntity);
		return valueEntity;
	}
	
	public static ValueEntity createValueEntity(ModelEntity modelEntity,Delegator delegator,Map<String,Object> values) {
		ValueEntity valueEntity = new ValueEntity();
		valueEntity.init(modelEntity, delegator, values);
		return valueEntity;
	}
	
	public Document toXml() {
		Document document = UtilXml.makeEmptyXmlDocument("Entity");
		Element documentElement = document.getDocumentElement();
		
		Element entityElement = document.createElement(getEntityName());
		documentElement.appendChild(entityElement);
		
		if(getModelEntity().getModelFields() != null) {
			Set<ModelField> modelFields = getModelEntity().getModelFields();
			for (ModelField modelField : modelFields) {
				String field = modelField.getName();
				String type = modelField.getType();
				Object value = getFieldValues().get(field);
				
				Element fieldEle = document.createElement(field);
				fieldEle.setAttribute("type", type);
				String stringVal = ObjectConverter.convert(value, String.class);
				if(stringVal == null) {
					stringVal = "";
				}
				
				fieldEle.appendChild(document.createTextNode(stringVal));
				entityElement.appendChild(fieldEle);
			}
		}
		
		//Adopt nodes from related entity.
		if(getOneMappedRelatedValueEntityMap() != null && !getOneMappedRelatedValueEntityMap().isEmpty()) {
			Set<Entry<String,ValueEntity>> entrySet = getOneMappedRelatedValueEntityMap().entrySet();
			for (Entry<String, ValueEntity> entry : entrySet) {
				String relationshipName = entry.getKey();
				//Element relnEle = document.createElement(relationshipName);
				
				ValueEntity value = entry.getValue();
				Document relnXml = value.toXml();
				
				List<Element> relatedEntityChildEles = DomUtils.getChildElements(relnXml.getDocumentElement());
				if(relatedEntityChildEles != null) {
					for (Element relatedEntityChildEle : relatedEntityChildEles) {
						Node adoptNode = document.adoptNode(relatedEntityChildEle);
						entityElement.appendChild(adoptNode);
					}
				}
			}
		}
		
		if(getManyMappedRelatedValueEntityMap() != null && !getManyMappedRelatedValueEntityMap().isEmpty()) {
			Set<Entry<String, Set<ValueEntity>>> entrySet = getManyMappedRelatedValueEntityMap().entrySet();
			for (Entry<String, Set<ValueEntity>> entry : entrySet) {
				String relationshipName = entry.getKey();
				
				Set<ValueEntity> values = entry.getValue();
				for (ValueEntity value : values) {
					Document relnXml = value.toXml();
					UtilXml.writeXmlDocument(relnXml);
					//Element entityEle = DomUtils.getChildElementByTagName(relnXml.getDocumentElement(), "Entity");
					
					List<Element> relatedEntityChildEles = DomUtils.getChildElements(relnXml.getDocumentElement());
					if(relatedEntityChildEles != null) {
						for (Element relatedEntityChildEle : relatedEntityChildEles) {
							Node adoptNode = document.adoptNode(relatedEntityChildEle);
							entityElement.appendChild(adoptNode);
						}
					}
				}
			}
		}
		
		UtilXml.writeXmlDocument(document);
		return document;
	}
	
	public ValueEntity makeRelatedValueEntity(String relationshipName) {
		return getDelegator().makeRelatedValueEntity(this, relationshipName);
	}
	
	public ValueEntity storeValueEntity() {
		//TODO - fetch the delegator and save this value entity
		return this;
	}
	
}
