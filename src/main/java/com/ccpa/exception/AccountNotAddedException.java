package com.ccpa.exception;

public class AccountNotAddedException extends Exception{

	public AccountNotAddedException() {

	}

	public AccountNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
			}

	public AccountNotAddedException(String message, Throwable cause) {
		super(message, cause);
			}

	public AccountNotAddedException(String message) {
		super(message);
			}

	public AccountNotAddedException(Throwable cause) {
		super(cause);
			}

}
