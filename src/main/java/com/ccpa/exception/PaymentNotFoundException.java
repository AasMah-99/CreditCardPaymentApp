package com.ccpa.exception;

public class PaymentNotFoundException extends Exception {

	public PaymentNotFoundException() {
		
	}

	public PaymentNotFoundException(String message) {
		super(message);
		
	}

	public PaymentNotFoundException(Throwable cause) {
		super(cause);
	
	}

	public PaymentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PaymentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
