/**
 * 
 */
package com.openappengine.service;

import java.util.List;

/**
 * The parent interface for all POJO Services. The Service's should have
 * getters for all the output parameters and setters for all the input parameters
 * to the Service.
 * 
 * The service method should be a void method with no input parameters.
 * 
 * @author hrishikesh.joshi
 * @since  Mar 13, 2012
 *
 */
public interface Service {

	void addSuccessMessage(String successMessage);
	
	List<String> getSuccessMessages();
	
	void addErrorMessage(String errorMessage);
	
	List<String> getErrorMessages();
	
	void setServiceContext(ServiceContext context);
	
	boolean isSuccess();

	boolean isError();
}
