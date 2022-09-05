package com.ccpa.exception;

public class CreditCardNotAddedException extends Exception{

	public CreditCardNotAddedException() {
	}

	public CreditCardNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreditCardNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditCardNotAddedException(String message) {
		super(message);
	}

	public CreditCardNotAddedException(Throwable cause) {
		super(cause);
	}
	
	

}
