package com.openappengine.bpm.procrepo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openappengine.bpm.graph.ProcessDefinition;


public class TestProcessRegistryManager {
	
	private ProcessRegistryManager processRegistryManager;
	
	@Before
	public void setup() {
		processRegistryManager = new ProcessRegistryManager();
	}
	
	@Test
	public void testLoadProcessRegistry() {
		String definitionFile = "TestProcessDef.xml";
		String correctProcessId = "process1";
		String incorrectProcessId = "process2";
		
		Assert.assertNotNull(definitionFile);
		try {
			processRegistryManager.loadProcessRegistry(definitionFile);
			ProcessDefinition processDefinition = processRegistryManager.getProcessInstanceByProcessId(correctProcessId);
			Assert.assertNotNull("Process Definition cannot be found from ProcessRegistryManager.",processDefinition);
			
			processDefinition = processRegistryManager.getProcessInstanceByProcessId(incorrectProcessId);
			Assert.assertNull("Incorrect Process Definition found from ProcessRegistryManager.",processDefinition);
		} catch (ProcessRegistryException e) {
			Assert.fail();
		}
	}

}
