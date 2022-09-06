package com.ccpa.exception;

public class CustomerNotUpdatedException extends Exception {

	public CustomerNotUpdatedException() {
		super();
	}

	public CustomerNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotUpdatedException(String message) {
		super(message);
	}

	public CustomerNotUpdatedException(Throwable cause) {
		super(cause);
	}

}
