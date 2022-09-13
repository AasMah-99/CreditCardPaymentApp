package com.ccpa.exception;

public class StatementNotUpdatedException extends Exception{

	public StatementNotUpdatedException() {
		super();
	}

	public StatementNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StatementNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatementNotUpdatedException(String message) {
		super(message);
	}

	public StatementNotUpdatedException(Throwable cause) {
		super(cause);
	}

	public StatementNotUpdatedException(Long statementId) {
		super("Statement not updated with id ---" + statementId);
	}
}