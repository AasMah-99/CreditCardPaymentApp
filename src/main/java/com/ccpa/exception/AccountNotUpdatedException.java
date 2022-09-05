package com.ccpa.exception;

public class AccountNotUpdatedException extends Exception {

	public AccountNotUpdatedException() {
			}

	public AccountNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AccountNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountNotUpdatedException(String message) {
		super(message);
			}

	public AccountNotUpdatedException(Throwable cause) {
		super(cause);
			}

}
