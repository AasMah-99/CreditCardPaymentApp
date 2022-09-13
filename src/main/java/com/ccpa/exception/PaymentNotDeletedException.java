package com.ccpa.exception;

public class PaymentNotDeletedException extends Exception {

	public PaymentNotDeletedException() {
		
	}

	public PaymentNotDeletedException(String message) {
		super(message);
		
	}

	public PaymentNotDeletedException(Throwable cause) {
		super(cause);
		
	}

	public PaymentNotDeletedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PaymentNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
