/**
 * 
 */
package com.openappengine.gui.engine.ui.form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class FormDefinitionContext implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Set<FormDefinition> formDefinitions = new HashSet<FormDefinition>();
	
	private String contextName;

	public Set<FormDefinition> getFormDefinitions() {
		return formDefinitions;
	}

	public void setFormDefinitions(Set<FormDefinition> formDefinitions) {
		this.formDefinitions = formDefinitions;
	}

	public void addFormDefinition(FormDefinition formDefinition) {
		this.formDefinitions.add(formDefinition);
	}
	
	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}
	
}
