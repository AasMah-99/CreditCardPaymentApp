package com.ccpa.exception;

public class StatementNotDeletedException extends Exception {
	
	public StatementNotDeletedException() {
		super();
	}

	public StatementNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StatementNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatementNotDeletedException(String message) {
		super(message);
	}

	public StatementNotDeletedException(Throwable cause) {
		super(cause);
	}
}
