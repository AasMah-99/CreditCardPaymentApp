package com.ccpa.service;

import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccpa.exception.PaymentNotAddedException;
import com.ccpa.exception.PaymentNotDeletedException;
import com.ccpa.exception.PaymentNotFoundException;
import com.ccpa.exception.PaymentNotUpdatedException;
import com.ccpa.model.Payment;
import com.ccpa.repository.PaymentRepository;

@Service                   //to declare that the class can handle all the service layer's task
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	//logic to add the payment details
	@Override
	public Payment addPayment(Payment payment) throws PaymentNotAddedException {
		if (Objects.isNull(payment))
			throw new PaymentNotAddedException("Values cannot be Null, Payment not added");
		return paymentRepository.save(payment);
	}

	//logic to remove the payment details
	@Override
	public Payment removePayment(Long id) throws PaymentNotDeletedException {
		paymentRepository.deleteById(id);
		if (paymentRepository.existsById(id)) {
			throw new PaymentNotDeletedException("Error Deleting Payment");
		}
		return null;
	}

	//logic to update the payment details
	@Override
	public Payment updatePayment(Long id, Payment payment) throws PaymentNotUpdatedException {
		if (paymentRepository.existsById(id)) {
			Payment paym = paymentRepository.save(payment);
			if (paym != null) {
				return paym;
			}
		}
		throw new PaymentNotUpdatedException("error updating payment");
	}

	//logic to get the payment details
	@Override
	public Payment getPayment(Long id) throws PaymentNotFoundException {
		if (id == null) {
			throw new PaymentNotFoundException("Payment Id cannot be Null");
		} else if (!paymentRepository.existsById(id)) {
			throw new PaymentNotFoundException("Payment Id " + id + " does not Exists");
		}
		return paymentRepository.findById(id).orElse(null);
	}
}
