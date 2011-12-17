/**
 * 
 */
package com.openappengine.facade.ui.form;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.EntityReference.IncludeFields;
import com.openappengine.facade.ui.common.FieldReference;
import com.openappengine.facade.ui.common.RenderMode;
import com.thoughtworks.xstream.XStream;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinitionReader {

	private String[] locations;

	protected final Logger logger = Logger.getLogger(getClass());

	private boolean validate;

	public List<FormDefinition> readFormDefinitions() {
		Validate.notEmpty(getLocations(), "No Location specified for FormDefinitions.");
		List<FormDefinition> allFormDefinitions = new ArrayList<FormDefinition>();

		XStream xStream = new XStream();
		xStream.aliasType("form-definitions", FormDefinitionContext.class);
		xStream.aliasType("form-definition", FormDefinition.class);
		xStream.aliasType("render-mode", RenderMode.class);
		xStream.aliasType("form-type", FormType.class);
		xStream.aliasType("form-layout", FieldLayout.class);
		xStream.aliasType("field-reference", FieldReference.class);
		
		xStream.addImplicitCollection(FormDefinitionContext.class, "formDefinitions");
		xStream.addImplicitCollection(FieldLayout.class, "fieldReferences");
		
		xStream.aliasField("entity-reference", FormDefinition.class, "entityReference");
		xStream.aliasField("field-layout", FormDefinition.class, "fieldLayout");
		xStream.aliasField("form-type", FormDefinition.class, "formType");
		xStream.aliasField("render-mode", FormDefinition.class, "renderMode");
		
		xStream.useAttributeFor(FormDefinition.class, "name");
		xStream.useAttributeFor(EntityReference.class, "entityName");
		xStream.useAttributeFor(EntityReference.class, "includeFields");
		xStream.useAttributeFor(FieldReference.class, "fieldName");
		
        xStream.aliasField("name", FormDefinition.class, "name");
        xStream.aliasField("entityName", EntityReference.class, "entityName");
        xStream.aliasField("includeFields", EntityReference.class, "include-fields");
        xStream.aliasField("fieldName", FieldReference.class, "field-name");
        
		for (String location : getLocations()) {
			FormDefinitionContext formDefinitionContext = readFormDefinition(xStream, location);
			allFormDefinitions.addAll(formDefinitionContext.getFormDefinitions());
		}
		return allFormDefinitions;
	}

	/**
	 * @param allFormDefinitions
	 * @param xStream
	 * @param location
	 * @return 
	 * @throws FormDefinitionException
	 */
	protected FormDefinitionContext readFormDefinition(XStream xStream, String location)
			throws FormDefinitionException {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(location);
			FormDefinitionContext formDefinitionContext = (FormDefinitionContext) xStream.fromXML(inputStream);
			if(isValidate()) {
				if(formDefinitionContext != null) {
					Set<FormDefinition> formDefinitions = formDefinitionContext.getFormDefinitions();
					if(formDefinitions != null) {
						for (FormDefinition formDefinition : formDefinitions) {
							// TODO - Handle Validations As per the business
							// logic. Throw RuntimeExceptions if some
							// business/application logic fails...Create a seperate Validator API for this.
							EntityReference entityReference = formDefinition.getEntityReference();
							if(entityReference != null) {
								IncludeFields includeFields = entityReference.getIncludeFields();
								if(includeFields == null) {
									includeFields = IncludeFields.ALL;
									entityReference.setIncludeFields(IncludeFields.ALL);
								}
								
								if(includeFields.equals(IncludeFields.REFERENCED)) {
									if (formDefinition.getFieldLayout() == null || formDefinition.getFieldLayout().getFieldReferences().isEmpty()) {
										throw new FormDefinitionException(
												"If IncludeFields=REFERENCED, Fields should be referred in the <field-layout> tag");
									}
								}
							}
						}
					}
				}
			}
			return formDefinitionContext;
		} catch (Throwable e) {
			throw new FormDefinitionException("Exception encountered while reading the FormDefinition", e);
		}
	}

	protected String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

}
