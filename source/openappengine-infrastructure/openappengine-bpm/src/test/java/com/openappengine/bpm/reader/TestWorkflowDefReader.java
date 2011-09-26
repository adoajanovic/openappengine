/**
 * 
 */
package com.openappengine.bpm.reader;

import org.junit.Assert;
import org.junit.Test;

import com.openappengine.bpm.model.Workflow;
import com.openappengine.bpm.workflow.WorkflowDefReader;
import com.openappengine.bpm.workflow.WorkflowDefinitionRegistry;

/**
 * @author hrishi
 *
 */
public class TestWorkflowDefReader {
	
	@Test
	public void testWorkflowReader() throws Exception {
		WorkflowDefReader.loadWorkflowDefinitionRegistry(getClass().getResource("/TestWorkflowDef.xml"));
		Workflow workflow = WorkflowDefinitionRegistry.getWorkflow("TestWorkflow");
		if(workflow == null) {
			Assert.fail("Workflow Not Added to Registry");
		}
	}

}
