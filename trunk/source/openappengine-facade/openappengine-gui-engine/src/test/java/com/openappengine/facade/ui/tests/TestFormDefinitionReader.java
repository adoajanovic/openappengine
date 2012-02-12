/**
 * 
 */
package com.openappengine.facade.ui.tests;

import org.junit.Test;

import com.openappengine.gui.engine.ui.form.FormDefinitionReader;

/**
 * @author hrishikesh.joshi
 * @Dec 15, 2011
 */
public class TestFormDefinitionReader {
	
	@Test
	public void readFormDefinitions() {
		FormDefinitionReader formDefinitionReader = new FormDefinitionReader();
		formDefinitionReader.setLocations(new String[]{"TestFormDefinitions.xml"});
		formDefinitionReader.readFormDefinitions();
	}

}
