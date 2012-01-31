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

	private Locale locale = Locale.getDefault();

	private String[] defaultMessageBundlePaths = new String[]{"messages"};
	
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
	public List<Message> getWarningMessages() {
		return warningMessages;
	}

	@Override
	public List<Message> getErroMessages() {
		return errorMessages;
	}

	@Override
	public List<Message> getInfoMessages() {
		return infoMessages;
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

}

