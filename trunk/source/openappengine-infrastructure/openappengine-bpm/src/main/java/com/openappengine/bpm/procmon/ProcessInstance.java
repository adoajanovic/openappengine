/**
 *  A process instance is one execution of a process definition. 
 *  One process instance can have many concurrent executions. 
 *  Executions are structured in a tree of which the ProcessInstance is the root.
 */
package com.openappengine.bpm.procmon;


/**
 * @author hrishi
 */
public class ProcessInstance extends Execution {

	private static final long serialVersionUID = 1L;
	
	/**
	 *  <code>ProcessStatus</code> of this process running in the ProcessEngine.
	 */
	private ProcessStatus processStatus;
	
	/**
	 *  The lookup key to the process defined in the <code>ProcessRegistry</code>.
	 */
	private String processDefinitionId;
	
	/**
	 *  ContextInstance associated with the ProcessInstance.
	 */
	private ContextInstance contextInstance;

	/**
	 * Default Constructor
	 */
	public ProcessInstance(String procRegistryId) {
		this.processDefinitionId = procRegistryId;
		pid = PIDGenerator.newProcessId();
		processStatus = new ProcessStatus();
	}

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

	/**
	 * @return the processDefinitionId
	 */
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	/**
	 * @param processDefinitionId the processDefinitionId to set
	 */
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	/**
	 * @return the contextInstance
	 */
	public ContextInstance getContextInstance() {
		return contextInstance;
	}

	/**
	 * @param contextInstance the contextInstance to set
	 */
	public void setContextInstance(ContextInstance contextInstance) {
		this.contextInstance = contextInstance;
	}

}
