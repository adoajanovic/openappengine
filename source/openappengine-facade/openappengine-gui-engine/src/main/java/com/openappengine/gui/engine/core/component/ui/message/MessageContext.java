/**
 * 
 */
package com.openappengine.gui.engine.core.component.ui.message;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.openappengine.gui.engine.core.context.GuiEngineContext;

/**
 * MessageContext is an interface that decouples the form labels/validation/information messages
 * from individual Widgets. The MessageContext is initialized everytime the {@link GuiEngineContext}
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
	
	void addSuccessMessage(String code);
	
	List<Message> getAllMessages();
	
	List<String> getWarningMessages();
	
	List<String> getErrorMessages();
	
	List<String> getInfoMessages();
	
	List<String> getSuccessMessages();
	
	Message getMessage(String elementName);
	
	void addMessage(String elementId,Message message);
	
	void addErrorMessage(String elementId,String message);
	
	void addWarningMessage(String elementId,String message);
	
	void addInfoMessage(String elementId,String message);
	
	void addSuccessMessage(String elementId,String message);
	
	void setLocale(Locale locale);
	
	void setMessageSource(MessageSource messageSource);

	void clearAllErrorMessages();
	
	void clearAllWarningMessages();
	
	void clearAllInfoMessages();
	
	void clearAllSuccessMessages();
	
	void clearAllMessages();
	
	void clearAllMessages(String id);
	
	void clearAllWarningMessages(String id);
	
	void clearAllErrorMessages(String id);
	
	void clearAllInfoMessages(String id);
	
	void clearAllSuccessMessages(String id);
	
	void addErrorMessage(String code,Object[] args);
	
	String getMessageText(String code);
}

