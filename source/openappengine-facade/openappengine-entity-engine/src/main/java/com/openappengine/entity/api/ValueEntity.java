/**
 * 
 */
package com.openappengine.entity.api;

import java.util.Map;

import com.openappengine.entity.model.ModelEntity;

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
	
	public static ValueEntity createValueEntity(ModelEntity modelEntity,Map<String,Object> values) {
		ValueEntity valueEntity = new ValueEntity();
		valueEntity.init(modelEntity, null, values);
		return valueEntity;
	}
	
}
