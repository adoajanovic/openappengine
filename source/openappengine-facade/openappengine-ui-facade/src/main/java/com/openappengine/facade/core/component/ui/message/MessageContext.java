/**
 * 
 */
package com.openappengine.facade.core.component.ui.message;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.openappengine.facade.core.context.GuiApplicationContext;

/**
 * MessageContext is an interface that decouples the form labels/validation/information messages
 * from individual Widgets. The MessageContext is initialized everytime the {@link GuiApplicationContext}
 * is initialized. 
 * 
 * The ActionHandler's, TransitionEventListeners, Validators get a handle to the MessageContext. So they can
 * add to the messages.
 * 
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
	
	List<String> getWarningMessages();
	
	List<String> getErroMessages();
	
	List<String> getInfoMessages();
	
	Message getMessage(String elementName);
	
	void addMessage(String elementId,Message message);
	
	void addErrorMessage(String elementId,String message);
	
	void addWarningMessage(String elementId,String message);
	
	void addInfoMessage(String elementId,String message);
	
	void setLocale(Locale locale);
	
	void setMessageSource(MessageSource messageSource);

	void clearAllErrorMessages();
	
	void clearAllWarningMessages();
	
	void clearAllInfoMessages();
	
	void clearAllMessages();
	
	void clearAllMessages(String id);
	
	void clearAllWarningMessages(String id);
	
	void clearAllErrorMessages(String id);
	
	void clearAllInfoMessages(String id);
}
