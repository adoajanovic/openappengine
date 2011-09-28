/**
 * 
 */
package com.openappengine.bpm.workflow;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.openappengine.bpm.model.ProcessDefinitionException;
import com.openappengine.bpm.model.ProcessExecutor;
import com.openappengine.bpm.model.Process;
import com.openappengine.bpm.model.State;
import com.openappengine.bpm.model.Transition;
import com.openappengine.bpm.model.Workflow;
import com.openappengine.bpm.model.WorkflowDefinitionException;
import com.openappengine.bpm.workflow.WorkflowDefinitionRegistry;
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
		
		boolean initProcessDefined = false;
		List<? extends Element> processDefList = UtilXml.childElementList(workflowElement, "processdef");
		if(processDefList != null) {
			for (Element processDefElement : processDefList) {
				Process process = readProcessDefElement(processDefElement);
				workflow.addProcess(process);
				if(process.getProcessName().equals(workflow.getInitProcess())) {
					initProcessDefined = true;
				}
			}
		}
		if(!initProcessDefined) {
			throw new WorkflowDefinitionException("No Init Process Defined for the Workflow");
		}
		return workflow;
	}

	private static Process readProcessDefElement(Element processDefElement) {
		Process processModel = new Process();
		String processName = processDefElement.getAttribute("name");
		if(processName == null) {
			throw new ProcessDefinitionException("Process Name cannot be null.");
		}
		
		//TODO - Remove the attribute
		/*String sequenceNo = processDefElement.getAttribute("sequence");
		processModel.setSequenceNo(Integer.parseInt(sequenceNo));*/
		
		processModel.setProcessName(processName);
		
		//TODO - Remove the attribute
		/*String aggregate = processDefElement.getAttribute("aggregate");
		processModel.setAggregateRoot(aggregate);*/
		
		//TODO - Remove the attribute
		/*String executor = processDefElement.getAttribute("executor");
		if(executor == null) {
			throw new ProcessDefinitionException("Executor cannot be null for Process: [" + processName + "].");
		}
		processModel.setProcessExecutor(new ProcessExecutor(executor));*/
		
		//TODO - Remove the attribute
		/*List<? extends Element> stateList = UtilXml.childElementList(processDefElement, "state");
		if(stateList != null) {
			for (Element stateElement : stateList) {
				State state = readStateElement(processName,stateElement);
				processModel.addState(state);
			}
		}*/
		return processModel;
	}

	/**
	 * TODO - Remove the method
	 */
	private static State readStateElement(String processName,
			Element stateElement) {
		State state = new State();
		String stateId = stateElement.getAttribute("id");
		if(stateId == null) {
			throw new ProcessDefinitionException("State Id cannot be null for Process: [" + processName + "].");		
		}
		
		boolean initialState = false;
		String initial = stateElement.getAttribute("initial");
		if(initial != null) {
			initialState = Boolean.getBoolean(initial);
		}
		
		boolean finalState = false;
		String finalStt = stateElement.getAttribute("final");
		if(finalStt != null) {
			finalState = Boolean.getBoolean(finalStt);
		}
		
		state.setId(stateId);
		state.setInitialState(initialState);
		state.setFinalState(finalState);
		
		List<? extends Element> transitionList = UtilXml.childElementList(stateElement, "transition");
		if(transitionList != null) {
			for (Element transitionElement : transitionList) {
				String event = transitionElement.getAttribute("event");
				String condition = transitionElement.getAttribute("condition");
				String action = transitionElement.getAttribute("action");
				String target = transitionElement.getAttribute("target");
				//TODO
				/*if(UtilString.isEmptyOrBlank(event) && UtilString.isEmptyOrBlank(condition) && UtilString.isEmptyOrBlank(action)) {
					throw new ProcessDefinitionException("All three attributes - event, condition and action cannot be null for StateId: [" + stateId + "].");
				}*/
				Transition transition = new Transition();
				transition.setAction(action);
				transition.setCondition(condition);
				transition.setTarget(target);
				transition.setEvent(event);
				
				state.addTransition(transition);
			}
			
		}
		return state;
	}

}
