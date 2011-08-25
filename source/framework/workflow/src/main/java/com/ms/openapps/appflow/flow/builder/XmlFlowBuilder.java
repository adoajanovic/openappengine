/**
 * 
 */
package com.ms.openapps.appflow.flow.builder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ms.openapps.appflow.context.WorkflowParameterContext;
import com.ms.openapps.appflow.exceptions.WorkflowConfigurationException;
import com.ms.openapps.appflow.flow.Flow;
import com.ms.openapps.appflow.params.InParam;
import com.ms.openapps.appflow.params.OutParam;
import com.ms.openapps.appflow.step.Step;
import com.ms.openapps.appflow.step.StepHandler;
import com.ms.openapps.appflow.util.UtilBoolean;
import com.ms.openapps.appflow.xml.XmlFlowTags;

/**
 * @author hrishi
 *
 */
public class XmlFlowBuilder implements IXmlFlowBuilder{

	
	/* (non-Javadoc)
	 * @see com.ms.openapps.appflow.flow.builder.IXmlFlowBuilder#createXmlFlow(org.w3c.dom.Document)
	 */
	@Override
	public Flow createClasspathXmlFlow(String xmlWorkFlowPath) throws IOException {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			//e.printStackTrace();
		}
		
		Document flowDocument = null;
		try {
			flowDocument = documentBuilder.parse(new File(xmlWorkFlowPath));
		} catch (SAXException e) {
			//e.printStackTrace();
		} 
		
		NodeList appFlows = flowDocument.getElementsByTagName(XmlFlowTags.NODE_APPFLOW);
		if(appFlows == null) {
			throw new WorkflowConfigurationException("No Workflow Found");
		}
		
		for(int i=0; i < appFlows.getLength(); i++) {
			Node appFlowNode = appFlows.item(i);
			if(appFlowNode.getNodeType() == Node.ELEMENT_NODE) {
				Element appFlowElement = (Element) appFlowNode;
				return createFlow(appFlowElement);
			}
		}
		return null;
	}
	
	/**
	 *  Create Flow from a Xml Document
	 * @param appFlowElement
	 * @return Flow
	 */
	private Flow createFlow(Element appFlowElement) {
		String id = appFlowElement.getAttribute(XmlFlowTags.ATTRIBUTE_FLOW_ID);
		if(id == null) {
			throw new WorkflowConfigurationException("Flow Id cannot be null");
		}
		
		List<Step> steps = new ArrayList<Step>();
		NodeList nodeSteps = appFlowElement.getElementsByTagName(XmlFlowTags.NODE_STEP);
		if(nodeSteps == null || nodeSteps.getLength() == 0) {
			throw new WorkflowConfigurationException("No Steps found for this flow");
		}
		for(int i = 0 ; i < nodeSteps.getLength(); i++) {
			Node stepNode = nodeSteps.item(i);
			if(stepNode.getNodeType() == Node.ELEMENT_NODE) {
				Element stepElement = (Element) stepNode;
				Step step = createStep(stepElement);
				//Add the Step to the Flow
				steps.add(step);
			}
		}
		
		Step firstStep = null;
		Step[] arrSteps = null;
		// TODO - Check if Sort the Steps for the Linear flow is needed here
		if(steps != null && steps.size() > 0) {
			firstStep = steps.get(0);
			arrSteps = steps.toArray(new Step[steps.size()]);
		}
		return new Flow(id, arrSteps, firstStep);
	}
	
	private InParam[] getInParams(Element paramsElement) {
		List<InParam> listInParams = new ArrayList<InParam>();
		NodeList paramNodes = paramsElement.getElementsByTagName(XmlFlowTags.NODE_PARAM);
		if(paramNodes != null && paramNodes.getLength() != 0) {
			for(int i=0; i < paramNodes.getLength() ; i++) {
				Node paramNode = paramNodes.item(i);
				if(paramNode.getNodeType() == Node.ELEMENT_NODE) {
					Element paramElement = (Element) paramNode;
					String attrType = paramElement
							.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_TYPE);
					if (attrType.equalsIgnoreCase("IN")) {
						try {
							String attrName = paramElement
									.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_NAME);
							String attrClass = paramElement
									.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_CLASS);
							Class<?> paramClass = Class.forName(attrClass);
							listInParams.add(new InParam(attrName, paramClass));
						} catch (ClassNotFoundException e) {
							throw new WorkflowConfigurationException(
									e.getMessage());
						}
					}
				}
			}
		}
		return listInParams.toArray(new InParam[0]);
	}
	
	private OutParam[] getOutParams(Element paramsElement) {
		List<OutParam> listOutParams = new ArrayList<OutParam>();
		NodeList paramNodes = paramsElement.getElementsByTagName(XmlFlowTags.NODE_PARAM);
		if(paramNodes != null && paramNodes.getLength() != 0) {
			for(int i=0; i < paramNodes.getLength() ; i++) {
				Node paramNode = paramNodes.item(i);
				if(paramNode.getNodeType() == Node.ELEMENT_NODE) {
					Element paramElement = (Element) paramNode;
					String attrType = paramElement
							.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_TYPE);
					if (attrType.equalsIgnoreCase("OUT")) {
						try {
							String attrName = paramElement
									.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_NAME);
							String attrClass = paramElement
									.getAttribute(XmlFlowTags.ATTRIBUTE_PARAM_CLASS);
							Class<?> paramClass = Class.forName(attrClass);
							listOutParams.add(new OutParam(attrName, paramClass));
						} catch (ClassNotFoundException e) {
							throw new WorkflowConfigurationException(
									e.getMessage());
						}
					}
				}
			}
		}
		return listOutParams.toArray(new OutParam[0]);
	}
	
	/**
	 *  Evaluate First Step for Step from Element Step
	 * @param firstStep
	 * @return Value for Attribute firstStep
	 */
	private boolean getFirstStep(Element stepElement) {
		String attrFirstStep = stepElement.getAttribute(XmlFlowTags.ATTRIBUTE_STEP_FIRSTSTEP);
		boolean bFirstStep = Boolean.FALSE;
		try {
			bFirstStep = UtilBoolean.parseStringAsBoolean(attrFirstStep);
		} catch (Exception e) {
			bFirstStep = Boolean.FALSE;
		}
		return bFirstStep;
	}
	
	private String getStepId(Element stepElement) {
		String attrId = stepElement.getAttribute(XmlFlowTags.ATTRIBUTE_STEP_ID);
		return attrId;
	}

	private Integer getSequence(Element stepElement) {
		String attrSequence = stepElement.getAttribute(XmlFlowTags.ATTRIBUTE_STEP_SEQUENCE);
		Integer sequence = 0;
		if(attrSequence != null) {
			sequence = Integer.parseInt(attrSequence);
		}
		return sequence;
	}
	
	private StepHandler getStepHandler(Element stepElement) {
		String attrStepHandler = stepElement.getAttribute(XmlFlowTags.ATTRIBUTE_STEP_STEPHANDLER);

		if(attrStepHandler == null) {
			throw new WorkflowConfigurationException("Step Handler cannot be null");
		}
		
		try {
			Class<?> classStepHandler = Class.forName(attrStepHandler);
			Object stepHandler = classStepHandler.newInstance();
			if (stepHandler instanceof StepHandler) {
				return (StepHandler) stepHandler;
			} else {
				throw new WorkflowConfigurationException(
						"Class : "
								+ attrStepHandler
								+ " should implement the interface com.ms.openapps.appflow.step.StepHandler");
			}
		} catch (Exception e) {
			throw new WorkflowConfigurationException("Error creating the Step Hanlder for Class : " + attrStepHandler + "cannot be found");
		}
	}
	
	private Step createStep(Element stepElement) {
		boolean bFirstStep = getFirstStep(stepElement);
		Integer sequence = getSequence(stepElement);
		String id = getStepId(stepElement);
		StepHandler stepHandler = getStepHandler(stepElement);
		InParam[] inParams = new InParam[0];
		OutParam[] outParams = new OutParam[0];
		
		NodeList paramsElementList = stepElement.getElementsByTagName(XmlFlowTags.NODE_PARAMS);
		if(paramsElementList == null || paramsElementList.getLength() > 0) {
			Element paramsElement = (Element) paramsElementList.item(0);
			inParams = getInParams(paramsElement);
			outParams = getOutParams(paramsElement);
		}
		return new Step(id, sequence, inParams, outParams, stepHandler,bFirstStep);
	}
	
}