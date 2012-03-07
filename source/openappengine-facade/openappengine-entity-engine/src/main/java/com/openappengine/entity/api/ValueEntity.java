/**
 * 
 */
package com.openappengine.entity.api;

import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.entity.delegator.Delegator;
import com.openappengine.entity.model.ModelEntity;
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
		Document document = UtilXml.makeEmptyXmlDocument("entity");
		Element documentElement = document.getDocumentElement();
		documentElement.setAttribute("entityName", getEntityName());
		
		if(getFieldValues() != null) {
			Iterator<String> keySetItr = getFieldValues().keySet().iterator();
			while (keySetItr.hasNext()) {
				String field = keySetItr.next();
				Object value = getFieldValues().get(field);
				
				Element fieldEle = document.createElement(field);
				String stringVal = ObjectConverter.convert(value, String.class);
				fieldEle.setNodeValue(stringVal);
				
				documentElement.appendChild(fieldEle);
			}
		}
		
		return document;
	}
	
}
