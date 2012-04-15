package com.openappengine.service;

import java.util.ArrayList;
import java.util.List;

import com.openappengine.repository.GenericRepository;
import com.openappengine.repository.context.RepositoryContext;
import com.openappengine.utility.UtilValidate;

/**
 * This is an Abstract Base Class for all the POJO Services,
 * with the common methods to set the context, and other house functions.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public abstract class AbstractDomainService implements Service {
	
	protected ServiceContext serviceContext;
	
	private static RepositoryContext repositoryContext;
	
	private List<String> errorMessages = new ArrayList<String>();
	
	private List<String> successMessages = new ArrayList<String>();
	
	private boolean success;
	
	private boolean error;
	
	static {
		repositoryContext = RepositoryContext.getInstance();
	}
	
	public <T extends GenericRepository> T getRepository(Class<T> t) { 
		return repositoryContext.getRepository(t);
	}

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
		if(UtilValidate.isEmpty(errorMessages)) {
			return true;
		}
		return false;
	}

	protected void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isError() {
		return !isSuccess();
	}

	protected void setError(boolean error) {
		this.error = error;
	}

}
