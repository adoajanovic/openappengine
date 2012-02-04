/**
 * 
 */
package com.openappengine.facade.core.component.ui.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author hrishikesh.joshi
 * @since  Jan 31, 2012
 *
 */
public class ResourceBundleMessageContext implements MessageContext {
	
	private ResourceBundleMessageSource messageSource;
	
	private String[] basenames;
	
	//Context Messages
	private List<Message> contextMessages = new ArrayList<Message>(); 
	
	private List<Message> errorMessages = new ArrayList<Message>();
	
	private List<Message> warningMessages = new ArrayList<Message>();
	
	private List<Message> infoMessages = new ArrayList<Message>();
	
	private List<Message> successMessages = new ArrayList<Message>();

	private Locale locale = Locale.getDefault();

	private String[] defaultMessageBundlePaths = new String[]{"defaultMessages"};
	
	/**
	 * @param basenames
	 */
	public ResourceBundleMessageContext() {
		super();
		this.basenames = defaultMessageBundlePaths;
		initializeDefaultMessageSource();
	}
	
	public ResourceBundleMessageContext(String[] basenames) {
		super();
		this.basenames = basenames;
		initializeDefaultMessageSource();
	}

	private void initializeDefaultMessageSource() {
		messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames(basenames);
	}

	@Override
	public void addMessage(String code, int severity) {
		contextMessages.add(new Message(code, severity));
	}

	@Override
	public void addMessage(Message message) {
		if(message == null) {
			return;
		}
		contextMessages.add(message);
	}

	@Override
	public void addErrorMessage(String code) {
		if(StringUtils.isEmpty(code)) {
			return;
		}
		
		Message errorMessage = new Message(code, MessageSeverity.ERROR);
		contextMessages.add(errorMessage);
		errorMessages.add(errorMessage);
	}
	
	public void addErrorMessage(String code,Object[] args) {
		if(StringUtils.isEmpty(code)) {
			return;
		}
		
		Message errorMessage = new Message(code,MessageSeverity.ERROR,args);
		contextMessages.add(errorMessage);
		errorMessages.add(errorMessage);
	}

	@Override
	public void addWarningMessage(String code) {
		if(StringUtils.isEmpty(code)) {
			return;
		}
		
		Message warningMessage = new Message(code, MessageSeverity.WARNING);
		contextMessages.add(warningMessage);
		warningMessages.add(warningMessage);
	}

	@Override
	public void addInfoMessage(String code) {
		if(StringUtils.isEmpty(code)) {
			return;
		}
		
		Message infoMessage = new Message(code, MessageSeverity.INFO);
		contextMessages.add(infoMessage);
		infoMessages.add(infoMessage);
	}

	@Override
	public List<Message> getAllMessages() {
		return contextMessages;
	}

	@Override
	public List<String> getWarningMessages() {
		List<String> warnMsgs = new ArrayList<String>();
		for (Message msg : warningMessages) {
			String message = messageSource.getMessage(msg.getCode(), null, locale);
			warnMsgs.add(message);
		}
		return warnMsgs;
	}

	@Override
	public List<String> getErrorMessages() {
		List<String> errorMsgs = new ArrayList<String>();
		for (Message msg : errorMessages) {
			String message = messageSource.getMessage(msg.getCode(), msg.getMessageArgs(), locale);
			errorMsgs.add(message);
		}
		return errorMsgs;
	}

	@Override
	public List<String> getInfoMessages() {
		List<String> infoMsgs = new ArrayList<String>();
		for (Message msg : infoMessages) {
			String message = messageSource.getMessage(msg.getCode(), null, locale);
			infoMsgs.add(message);
		}
		return infoMsgs;
	}

	@Override
	public void setLocale(Locale locale) {
		if(locale == null) {
			this.locale = Locale.getDefault();
		}
		this.locale = locale;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		if(messageSource == null) {
			initializeDefaultMessageSource();
		}
		if(supportsMessageSource(messageSource)) {
			this.messageSource = (ResourceBundleMessageSource) messageSource;
		}
	}

	/**
	 * @param messageSource
	 * @return
	 */
	private boolean supportsMessageSource(MessageSource messageSource) {
		return ResourceBundleMessageSource.class.isAssignableFrom(messageSource.getClass());
	}

	@Override
	public Message getMessage(String elementName) {
		return null;
	}

	@Override
	public void addMessage(String elementId, Message message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addErrorMessage(String elementId, String message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addWarningMessage(String elementId, String message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addInfoMessage(String elementId, String message) {
		infoMessages.clear();
	}

	@Override
	public void clearAllErrorMessages() {
		errorMessages.clear();
	}

	@Override
	public void clearAllWarningMessages() {
		infoMessages.clear();
	}

	@Override
	public void clearAllInfoMessages() {
		infoMessages.clear();
	}

	@Override
	public void clearAllMessages(String id) {
		infoMessages.clear();
		errorMessages.clear();
		warningMessages.clear();
	}

	@Override
	public void clearAllWarningMessages(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearAllErrorMessages(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAllInfoMessages(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearAllMessages() {
		infoMessages.clear();
		errorMessages.clear();
		warningMessages.clear();
		successMessages.clear();
		contextMessages.clear();
	}

	@Override
	public List<String> getSuccessMessages() {
		List<String> successMsgs = new ArrayList<String>();
		for (Message msg : successMessages) {
			String message = messageSource.getMessage(msg.getCode(), null, locale);
			successMsgs.add(message);
		}
		return successMsgs;
	}

	@Override
	public void addSuccessMessage(String elementId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAllSuccessMessages() {
		successMessages.clear();
	}

	@Override
	public void clearAllSuccessMessages(String id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addSuccessMessage(String code) {
		if(StringUtils.isEmpty(code)) {
			return;
		}
		
		Message warningMessage = new Message(code, MessageSeverity.SUCCESS);
		contextMessages.add(warningMessage);
		successMessages.add(warningMessage);
	}

}

