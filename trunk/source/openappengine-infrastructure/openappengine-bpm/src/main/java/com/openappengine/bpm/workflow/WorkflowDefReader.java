/**
 * 
 */
package com.openappengine.bpm.workflow;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.bpm.model.State;
import com.openappengine.bpm.model.Workflow;
import com.openappengine.utility.UtilString;
import com.openappengine.utility.UtilXml;

/**
 * @author hrishi
 *
 */
public class WorkflowDefReader {
	
	public static void loadWorkflowDefinitionRegistry(InputStream inputStream) throws Exception {
		Document document = UtilXml.readXmlDocument(inputStream);
		loadWorkflowDefinitionRegistry(document);
	}
	
	public static void loadWorkflowDefinitionRegistry(URL url) throws Exception {
		Document document = UtilXml.readXmlDocument(url);
		loadWorkflowDefinitionRegistry(document);
	}
	
	public static void loadWorkflowDefinitionRegistry(Document doc) {
		if(doc == null) {
			throw new ProcessDefinitionException("Input Document cannot be null.");
		}
		Element rootElement = doc.getDocumentElement();
		List<? extends Element> workflowDefList = UtilXml.childElementList(rootElement, "workflow");
		if(workflowDefList != null) {
			for (Element workflowElement : workflowDefList) {
				Workflow workflow = readWorkflowElement(workflowElement);
				WorkflowDefinitionRegistry.addWorkflow(workflow);
			}
		}
	}

	private static Workflow readWorkflowElement(Element workflowElement) {
		Workflow workflow = new Workflow();
		String name = workflowElement.getAttribute("name");
		if(UtilString.isEmptyOrBlank(name)) {
			throw new ProcessDefinitionException("Workflow Name cannot be empty.");	
		}
		
		String initProcess = workflowElement.getAttribute("init-process");
		workflow.setName(name);
		workflow.setInitProcess(initProcess);
		
		if(UtilString.isEmptyOrBlank(initProcess)) {
			throw new ProcessDefinitionException("Workflow init-process cannot be empty.");	
		}
		
		readProcessElements(workflowElement, workflow);
		
		return workflow;
	}

	/**
	 * @param workflowElement
	 * @param workflow
	 * @throws WorkflowDefinitionException
	 */
	protected static void readProcessElements(Element workflowElement,
			Workflow workflow) throws WorkflowDefinitionException {
		boolean initProcessDefined = false;
		List<? extends Element> processElementList = UtilXml.childElementList(workflowElement, "process");
		if(processElementList != null) {
			for (Element processElement : processElementList) {
				State process = readProcessElement(processElement);
				workflow.addProcess(process);
				if(process.getName().equals(workflow.getInitProcess())) {
					initProcessDefined = true;
				}
			}
		}
		if(!initProcessDefined) {
			throw new WorkflowDefinitionException("No Init State Defined for the Workflow");
		}
	}

	private static State readProcessElement(Element processDefElement) {
		State processModel = new State();
		String processName = processDefElement.getAttribute("name");
		if(processName == null) {
			throw new ProcessDefinitionException("State Name cannot be null.");
		}
		
		processModel.setName(processName);
		
		return processModel;
	}

}
