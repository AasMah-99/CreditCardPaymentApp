package com.ccpa.exception;

public class PaymentNotUpdatedException extends Exception {

	public PaymentNotUpdatedException() {
		
	}

	public PaymentNotUpdatedException(String message) {
		super(message);
		
	}

	public PaymentNotUpdatedException(Throwable cause) {
		super(cause);
		
	}

	public PaymentNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PaymentNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
