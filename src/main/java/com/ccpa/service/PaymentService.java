package com.ccpa.service;

import com.ccpa.exception.PaymentNotAddedException;
import com.ccpa.exception.PaymentNotDeletedException;
import com.ccpa.exception.PaymentNotFoundException;
import com.ccpa.exception.PaymentNotUpdatedException;
import com.ccpa.model.Payment;

public interface PaymentService {
	public Payment addPayment(Payment payment) throws PaymentNotAddedException;

	public Payment removePayment(Long id) throws PaymentNotDeletedException;

	public Payment updatePayment(Long id, Payment payment) throws PaymentNotUpdatedException;

	public Payment getPayment(Long id) throws PaymentNotFoundException;
}
