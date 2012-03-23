package com.openappengine.entity.api;

public class RequiredFieldMissingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequiredFieldMissingException() {
	}

	public RequiredFieldMissingException(String message) {
		super(message);
	}

	public RequiredFieldMissingException(Throwable cause) {
		super(cause);
	}

	public RequiredFieldMissingException(String message, Throwable cause) {
		super(message, cause);
	}

}
