package com.ccpa.exception;

public class AccountNotDeletedException extends Exception {

	public AccountNotDeletedException() {
			}

	public AccountNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
			}

	public AccountNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountNotDeletedException(String message) {
		super(message);
		
	}

	public AccountNotDeletedException(Throwable cause) {
		super(cause);
		
	}

}
