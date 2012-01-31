/**
 * 
 */
package com.openappengine.facade.core.component.ui.message;

import java.util.List;

/**
 * @author hrishi
 * since Jan 31, 2012
 */
public interface MessageContext {
	
	void addMessage(String code,int severity);
	
	void addMessage(Message message);
	
	void addErrorMessage(String code);
	
	void addWarningMessage(String code);
	
	void addInfoMessage(String code);
	
	List<Message> getAllMessages();
	
	List<Message> getWarningMessages();
	
	List<Message> getErroMessages();
	
	List<Message> getInfoMessages();

}
