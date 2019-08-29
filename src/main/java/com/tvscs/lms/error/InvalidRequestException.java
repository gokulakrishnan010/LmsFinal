package com.tvscs.lms.error;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public InvalidRequestException() {
		super();
	}

	public InvalidRequestException(final String message) {
		super(message);
	}

}
