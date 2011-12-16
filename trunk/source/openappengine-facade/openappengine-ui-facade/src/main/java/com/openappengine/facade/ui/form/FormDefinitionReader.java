/**
 * 
 */
package com.openappengine.facade.ui.form;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import com.openappengine.facade.ui.common.EntityReference;
import com.openappengine.facade.ui.common.RenderMode;
import com.thoughtworks.xstream.XStream;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinitionReader {

	private String[] locations;

	protected final Logger logger = Logger.getLogger(getClass());

	public List<FormDefinition> readFormDefinitions() {
		Validate.notEmpty(getLocations(), "No Location specified for FormDefinitions.");
		List<FormDefinition> allFormDefinitions = new ArrayList<FormDefinition>();

		XStream xStream = new XStream();
		xStream.aliasType("form-definitions", FormDefinitionContext.class);
		xStream.aliasType("form-definition", FormDefinition.class);
		xStream.aliasType("render-mode", RenderMode.class);
		xStream.aliasType("form-type", FormType.class);
		xStream.aliasType("form-layout", FieldLayout.class);
		
		xStream.addImplicitCollection(FormDefinitionContext.class, "formDefinitions");
		
		xStream.aliasField("entity-reference", FormDefinition.class, "entityReference");
		xStream.aliasField("field-layout", FormDefinition.class, "fieldLayout");
		xStream.aliasField("form-type", FormDefinition.class, "formType");
		xStream.aliasField("render-mode", FormDefinition.class, "renderMode");
		
		xStream.useAttributeFor(FormDefinition.class, "name");
		xStream.useAttributeFor(EntityReference.class, "entityName");
		xStream.useAttributeFor(EntityReference.class, "includeFields");
		
        xStream.aliasField("name", FormDefinition.class, "name");
        xStream.aliasField("entityName", EntityReference.class, "entityName");
        xStream.aliasField("includeFields", EntityReference.class, "include-fields");
        
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
			return formDefinitionContext;
		} catch (Throwable e) {
			throw new FormDefinitionException("Exception encountered while reading the FormDefinition", e);
		}
	}

	/**
	 * 
	 */
	protected void test() {
		FormDefinition formDefinition = new FormDefinition();
		formDefinition.setEntityReference(new EntityReference("CodeType"));
		formDefinition.setFieldLayout(FieldLayout.getDefault());
		formDefinition.setFormType(FormType.SIMPLE);
		formDefinition.setRenderMode(RenderMode.READ_WRITE);

		FormDefinitionContext formDefinitionContext = new FormDefinitionContext();
		formDefinitionContext.addFormDefinition(formDefinition);

		XStream xStream = new XStream();
		// form-definitions : Root Tag
		xStream.aliasType("form-definitions", FormDefinitionContext.class);
		xStream.addImplicitCollection(FormDefinitionContext.class, "formDefinitions");
		xStream.aliasType("form-definition", FormDefinition.class);
		xStream.aliasType("entity-reference", EntityReference.class);
		xStream.aliasType("form-layout", FieldLayout.class);
		xStream.aliasType("render-mode", RenderMode.class);
		xStream.aliasType("form-type", FormType.class);

		String xml = xStream.toXML(formDefinitionContext);
		System.out.println(xml);
	}

	protected String[] getLocations() {
		return locations;
	}

	public void setLocations(String[] locations) {
		this.locations = locations;
	}

}
