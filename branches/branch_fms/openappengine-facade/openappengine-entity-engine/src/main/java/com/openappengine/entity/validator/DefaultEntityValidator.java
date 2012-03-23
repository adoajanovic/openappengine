/**
 * 
 */
package com.openappengine.entity.validator;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.openappengine.entity.DataBeanWrapper;
import com.openappengine.entity.definition.Entity;
import com.openappengine.entity.definition.Field;

/**
 * @author hrishi
 * since Feb 1, 2012
 */
public class DefaultEntityValidator implements EntityValidator {
	
	private Entity entityDefinition;
	
	/**
	 * @param entityDefinition
	 */
	public DefaultEntityValidator(Entity entityDefinition) {
		super();
		Assert.notNull(entityDefinition, "No EntityDefinition found.!");
		this.entityDefinition = entityDefinition;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		Class<?> entityClass = entityDefinition.getEntityClass();
		return entityClass.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//TODO - Add Validation Based on EntityDefinition Created.
		
		DataBeanWrapper beanWrapper = new DataBeanWrapper(target);
		
		List<Field> fields = entityDefinition.getFields();
		if(fields != null) {
			for (Field field : fields) {
				
				String property = field.getProperty();
				Object value = beanWrapper.get(property);
				
				//Required Field.
				if(field.isRequired() && !field.isAutoincrement()) {
					ValidationUtils.rejectIfEmpty(errors, property, composeRequiredFieldErrorCode(field));
				}
				
				//Numeric Field Validation
				if(field.isNumeric()) {
					if(StringUtils.isNumeric("" + value)) {
						errors.rejectValue(property, composeNumericFieldErrorCode(field), composeRequiredFieldErrorCode(field));
					}
				} else if(field.isAlpha()) {	//Alpha Field Validation
					if(StringUtils.isAlpha(""+ value)) {
						errors.rejectValue(property, composeAlphaFieldErrorCode(field), composeAlphaFieldErrorCode(field));
					}
				}
				
			}
		}
		
	}

	/**
	 * @param field
	 * @return
	 */
	private String composeNumericFieldErrorCode(Field field) {
		return field.getName()+ ".isNumeric";
	}

	/**
	 * @param field
	 * @return
	 */
	private String composeRequiredFieldErrorCode(Field field) {
		return field.getName()+ ".required";
	}

	/**
	 * @param field
	 * @return
	 */
	private String composeAlphaFieldErrorCode(Field field) {
		return field.getName()+ ".isAlpha";
	}
}
