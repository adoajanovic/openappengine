/**
 * 
 */
package com.openappengine.entity.api;

import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
		return document;
	}
	
}
