package com.ccpa.exception;

public class StatementNotAddedException extends Exception {

	public StatementNotAddedException() {
		super();
	}

	public StatementNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StatementNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatementNotAddedException(String message) {
		super(message);
	}

	public StatementNotAddedException(Throwable cause) {
		super(cause);
	}

}
