/**
 * 
 */
package com.openappengine.gui.engine.ui.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinitionCache {

	private Map<String,FormDefinition> formDefinitionMap;
	
	private FormDefinitionReader formDefinitionReader;
	
	public void initCache() {
		formDefinitionMap = new HashMap<String, FormDefinition>();
		List<FormDefinition> formDefinitions = formDefinitionReader.readFormDefinitions();
		if(formDefinitions != null) {
			for (FormDefinition formDefinition : formDefinitions) {
				formDefinitionMap.put(formDefinition.getName(), formDefinition);
			}
		}
	}
	
	public FormDefinition getFormDefinition(String name) {
		return formDefinitionMap.get(name);
	}

	protected FormDefinitionReader getFormDefinitionReader() {
		return formDefinitionReader;
	}

	public void setFormDefinitionReader(FormDefinitionReader formDefinitionReader) {
		this.formDefinitionReader = formDefinitionReader;
	}
	
}
