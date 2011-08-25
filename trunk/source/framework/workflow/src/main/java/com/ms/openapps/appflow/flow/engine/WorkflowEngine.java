/**
 * 
 */
package com.ms.openapps.appflow.flow.engine;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ms.openapps.appflow.context.WorkflowParameterContext;
import com.ms.openapps.appflow.exceptions.WorkflowConfigurationException;
import com.ms.openapps.appflow.flow.Flow;
import com.ms.openapps.appflow.flow.builder.IXmlFlowBuilder;

/**
 * @author hrishi
 *
 */
public class WorkflowEngine {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	private List<String> workflows;
	
	private IXmlFlowBuilder xmlFlowBuilder;
	
	private Map<String, Flow> workflowContext;
	
	/**
	 * 	Init Workflows with XmlFlowBuilder
	 */
	public void initWorkflows() {
		if(workflows!=null && workflows.size()!=0) {
			for(String workflow : workflows) {
				try {
					Flow flow = xmlFlowBuilder.createClasspathXmlFlow(workflow);
					addWorkFlow(flow.getId(), flow);
				} catch (IOException e) {
					logger.error("Error encountered while loading the Workflow " + workflow);
					throw new WorkflowConfigurationException("Error encountered while loading the Workflow " + workflow,e);
				}
			}
		}
	}
	
	/**
	 *  Execute the Workflow
	 * @param flowId
	 * @throws WorkflowRunnerException
	 */
	public void executeWorkflow(String flowId,WorkflowParameterContext workflowParameterContext) throws WorkflowRunnerException {
		if(workflowContext == null || !workflowContext.containsKey(flowId)) {
			logger.error("Workflow " + flowId + " not found");
			throw new WorkflowRunnerException("Workflow " + flowId + " not found");
		}
		Flow workflow = workflowContext.get(flowId);
		FlowExecutor flowExecutor = new FlowExecutor(workflow,workflowParameterContext);
		flowExecutor.executeFlow();
	}

	/**
	 *  Add workflow to the flowContext
	 * @param flow
	 */
	private void addWorkFlow(String flowId,Flow flow) {
		if(workflowContext == null) {
			workflowContext = new HashMap<String, Flow>();
		}
		workflowContext.put(flowId, flow);
	}
	
	/**
	 * @param workflows the workflows to set
	 */
	public void setWorkflows(List<String> workflows) {
		this.workflows = workflows;
	}

	/**
	 * @return the workflows
	 */
	public List<String> getWorkflows() {
		return workflows;
	}

	/**
	 * @param xmlFlowBuilder the xmlFlowBuilder to set
	 */
	public void setXmlFlowBuilder(IXmlFlowBuilder xmlFlowBuilder) {
		this.xmlFlowBuilder = xmlFlowBuilder;
	}

	/**
	 * @return the xmlFlowBuilder
	 */
	public IXmlFlowBuilder getXmlFlowBuilder() {
		return xmlFlowBuilder;
	}

}