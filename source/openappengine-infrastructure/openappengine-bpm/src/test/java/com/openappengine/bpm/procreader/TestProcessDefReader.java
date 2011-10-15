/**
 * 
 */
package com.openappengine.bpm.procreader;

import junit.framework.Assert;

import org.junit.Test;

import com.openappengine.bpm.graph.ProcessDefinition;
import com.openappengine.bpm.procreader.IProcessDefReader;
import com.openappengine.bpm.procreader.ProcessDefReader;
import com.openappengine.bpm.procreader.ProcessDefinitionException;


/**
 * @author hrishi
 *
 */
public class TestProcessDefReader {
	
	@Test
	public void testReadProcessDefinition() throws ProcessDefinitionException {
		IProcessDefReader processDefReader = new ProcessDefReader(getClass().getClassLoader().getResourceAsStream("TestProcessDef.xml"));
		ProcessDefinition processDefinition = processDefReader.readProcessDefinition();
		Assert.assertNotNull("ProcessDefinition found null..", processDefinition);
	}
}
