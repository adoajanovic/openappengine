package com.openappengine.service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an Abstract Base Class for all the POJO Services,
 * with the common methods to set the context, and other house functions.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public abstract class AbstractDomainService implements Service {
	
	private ServiceContext serviceContext;
	
	private List<String> errorMessages = new ArrayList<String>();
	
	private List<String> successMessages = new ArrayList<String>();
	
	private boolean success;
	
	private boolean error;

	@Override
	public void addSuccessMessage(String successMessage) {
		if(this.successMessages == null) {
			this.successMessages = new ArrayList<String>();
		}
		this.successMessages.add(successMessage);
	}

	@Override
	public List<String> getSuccessMessages() {
		return successMessages;
	}

	@Override
	public void addErrorMessage(String errorMessage) {
		if(this.errorMessages == null) {
			this.errorMessages = new ArrayList<String>();
		}
		this.errorMessages.add(errorMessage);
	}

	@Override
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	@Override
	public void setServiceContext(ServiceContext context) {
		this.serviceContext = context;		
	}
	
	protected ServiceContext getServiceContext() {
		return serviceContext;
	}

	public boolean isSuccess() {
		return success;
	}

	protected void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isError() {
		return error;
	}

	protected void setError(boolean error) {
		this.error = error;
	}

}
