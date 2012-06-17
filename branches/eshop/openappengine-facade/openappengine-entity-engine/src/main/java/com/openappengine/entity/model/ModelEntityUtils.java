/**
 * 
 */
package com.openappengine.entity.model;

import java.util.Map;

import org.springframework.util.Assert;

import com.openappengine.entity.context.EntityEngineFacadeContext;

/**
 * @author hrishi
 * since Mar 10, 2012
 */
public class ModelEntityUtils {
	
	public static Class<?> getModelFieldType(String field) throws ClassNotFoundException {
		Map<String,String> map = EntityEngineFacadeContext.getDefaultFieldTypeMap();
		String fieldClassAsString = map.get(field);
		Assert.notNull(fieldClassAsString, "No Class registered for ModelField :" + field);
		return Class.forName(fieldClassAsString);
	}

}
