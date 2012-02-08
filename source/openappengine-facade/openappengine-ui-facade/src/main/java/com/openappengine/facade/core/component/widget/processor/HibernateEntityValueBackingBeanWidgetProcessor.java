/**
 * 
 */
package com.openappengine.facade.core.component.widget.processor;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;

import com.openappengine.facade.core.component.widget.context.HibernateBackingBeanWigetProcessorContext;
import com.openappengine.facade.core.component.widget.context.WidgetProcessorContext;
import com.openappengine.facade.entity.PojoEntityValue;
import com.openappengine.facade.entity.definition.EntityDefinition;
import com.openappengine.facade.entity.definition.FieldDefinition;
import com.openappengine.facade.fsm.TransitionEvent;

/**
 * @author hrishikesh.joshi
 * @since  Feb 2, 2012
 *
 */
public abstract class HibernateEntityValueBackingBeanWidgetProcessor implements EntityValueBackingBeanWidgetProcessor {

	protected HibernateBackingBeanWigetProcessorContext widgetProcessorContext;
	
	protected Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Class<?> getWidgetProcessorContextClass() {
		return HibernateBackingBeanWigetProcessorContext.class;
	}

	@Override
	public void setWidgetProcessorContext(WidgetProcessorContext context) {
		if(context == null) {
			throw new IllegalArgumentException("WidgetProcessorContext cannot be null.");
		}
		if(!supportsWidgetProcessorContext(context.getClass())) {
			throw new IllegalArgumentException(
					"WidgetProcessor does not support the WidgetProcessorContext class:"
							+ context.getClass()
							+ ". Should extend from "
							+ HibernateBackingBeanWigetProcessorContext.class
									.getName() + ".");
		}
		this.widgetProcessorContext = (HibernateBackingBeanWigetProcessorContext) context;
	}

	public boolean supportsWidgetProcessorContext(Class<?> clazz) {
		if(clazz == null || getWidgetProcessorContextClass() == null) {
			return false;
		}
		return getWidgetProcessorContextClass().isAssignableFrom(clazz);
	}

	protected HibernateBackingBeanWigetProcessorContext getWidgetProcessorContext() {
		return widgetProcessorContext;
	}

	@Override
	public PojoEntityValue processWidget() {
		PojoEntityValue pojoEntityValue = null;
		try {
			//Get PojoEntityValue from the EL Context.
			pojoEntityValue = (PojoEntityValue) widgetProcessorContext.getELContext().getVariable(widgetProcessorContext.getWidgetBackingObjectValueRef());
			Object previousInstance = pojoEntityValue.getInstance();
			
			Object newInstance = widgetProcessorContext.getWidgetBackingClass().newInstance();
			
			//Validate and Bind PojoEntityValue BackingBean.
			ServletRequestDataBinder binder = new ServletRequestDataBinder(newInstance);
			binder.setValidator(pojoEntityValue.getEntityDefinition().getEntityValidator());
			
			//Bind the Instance to the request.
			binder.bind((ServletRequest) widgetProcessorContext.getExternalContext().getRequest());
			
			BindingResult bindingResult = binder.getBindingResult();
			if (bindingResult != null) {
				if(bindingResult.hasErrors()) {
					//If binding errors exists, add the error messages to the message context and return the previous entity value.
					addErrorMessages(bindingResult,pojoEntityValue.getEntityDefinition());
					
					//Bind all the successful bindings.
					BeanWrapper prevInstanceBeanWrapper = new BeanWrapperImpl(previousInstance);
					BeanWrapper newInstanceBeanWrapper = new BeanWrapperImpl(newInstance);
					
					
					List<FieldError> fieldErrors = bindingResult.getFieldErrors();
					if(fieldErrors != null) {
						for (FieldError fieldError : fieldErrors) {
							String field = fieldError.getField();
							
							Object prevValue = prevInstanceBeanWrapper.getPropertyValue(field);
							
							//Restore the previous value.
							newInstanceBeanWrapper.setPropertyValue(field, prevValue);
						}
					}
					
					getModelMap().addAttribute(widgetProcessorContext.getWidgetId(),newInstance);
					return pojoEntityValue;
				}
			}
			
			pojoEntityValue.setInstance(newInstance);
			
			//Process Widget.
			doProcessWidget();
			
			// If the PojoEntityValue has not been removed from the ELContext, then bind the model map with the entityvalue instance.
			if (fetchEntityValueFromELContext() != null) {
				// Replace the ModelMap attribute with the new binded instance.
				getModelMap().addAttribute(widgetProcessorContext.getWidgetId(),pojoEntityValue.getInstance());
				return pojoEntityValue;
			} else {
				getModelMap().addAttribute(widgetProcessorContext.getWidgetId(),null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @param bindingResult
	 */
	private void addErrorMessages(BindingResult bindingResult,EntityDefinition entityDefinition) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String fieldName = getFieldName(entityDefinition, fieldError.getField());
			logger.error("Value - [" + fieldError.getRejectedValue() + "] cannot be set to " + fieldName);
			widgetProcessorContext.getMessageContext().addErrorMessage(fieldError.getCode(),new Object[]{fieldError.getRejectedValue(),fieldName});
		}
	}

	/**
	 * @param entityDefinition
	 * @param field
	 */
	private String getFieldName(EntityDefinition entityDefinition, String field) {
		String fieldName;
		List<FieldDefinition> fields = entityDefinition.getFields();
		for (FieldDefinition fieldDefinition : fields) {
			if(fieldDefinition.getProperty().equals(field)) {
				fieldName = fieldDefinition.getName();
				return fieldName;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	private ModelMap getModelMap() {
		return widgetProcessorContext.getExternalContext().getModelMap();
	}
	
	/**
	 * @return
	 */
	protected Object fetchEntityValueFromELContext() {
		return widgetProcessorContext.getELContext().getVariable(widgetProcessorContext.getWidgetBackingObjectValueRef());
	}

	/**
	 * @param triggeredTransition
	 * @return
	 */
	protected TransitionEvent createTransitionEvent(String triggeredTransition) {
		return new TransitionEvent(triggeredTransition,
				widgetProcessorContext.getExternalContext(),
				widgetProcessorContext.getELContext(),
				widgetProcessorContext.getMessageContext());
	}
	
	protected abstract void doProcessWidget();
}