package com.ccpa.exception;

public class PaymentNotAddedException extends Exception {

	public PaymentNotAddedException() {
		
	}

	public PaymentNotAddedException(String message) {
		super(message);
		
	}

	public PaymentNotAddedException(Throwable cause) {
		super(cause);
		
	}

	public PaymentNotAddedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PaymentNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
