package com.ccpa.exception;

public class StatementNotFoundException extends Exception {

	public StatementNotFoundException() {
		super();
	}

	public StatementNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StatementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatementNotFoundException(String message) {
		super(message);
	}

	public StatementNotFoundException(Throwable cause) {
		super(cause);
	}
}

