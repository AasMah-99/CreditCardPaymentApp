package com.ccpa.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ccpa.exception.PaymentNotAddedException;
import com.ccpa.exception.PaymentNotDeletedException;
import com.ccpa.exception.PaymentNotFoundException;
import com.ccpa.exception.PaymentNotUpdatedException;
import com.ccpa.model.Payment;
import com.ccpa.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	private static final String status = "status";
	private static final String message = "message";

	// @Autowired - to inject the object dependencies
	@Autowired
	PaymentService paymentService;

	/*
	 * To add the Data of Payment
	 * 
	 * @PostMapping - to handle POST(add) type of request
	 */
	@PostMapping("/addPayment")
	public ResponseEntity<Map<String, Object>> addPayment(@RequestBody Payment payment)
			throws PaymentNotAddedException {
		Map<String, Object> paym = new HashMap<>();
		paym.put(status, true);
		paym.put(message, "Payment inserted successfully!");
		paym.put("data", paymentService.addPayment(payment));
		return new ResponseEntity<>(paym, HttpStatus.CREATED);
	}

	/*
	 * To Delete Data of Payment with Payment ID
	 * 
	 * @DeleteMapping - to handle DELETE(delete) type of request
	 */
	@DeleteMapping("/deletePayment/{paymentId}")
	public ResponseEntity<Map<String, Object>> removePayment(@PathVariable("paymentId") Long paymentId)
			throws PaymentNotDeletedException {
		Map<String, Object> paym = new HashMap<>();
		paym.put(status, true);
		paym.put(message, "Payment deleted successfully!");
		paym.put("data", paymentService.removePayment(paymentId));
		return new ResponseEntity<>(paym, HttpStatus.OK);
	}

	/*
	 * To Update Data of Payment with Payment ID
	 * 
	 * @PutMapping - to handle PUT(update) type of request
	 */
	@PutMapping("/updatePayment/{paymentId}")
	public ResponseEntity<Map<String, Object>> updatePayment(@RequestBody Payment payment,
			@PathVariable("paymentId") Long paymentId) throws PaymentNotUpdatedException {
		Map<String, Object> paym = new HashMap<>();
		paym.put(status, true);
		paym.put(message, "Payment Updated Successfully");
		paym.put("data", paymentService.updatePayment(paymentId, payment));
		return new ResponseEntity<>(paym, HttpStatus.OK);
	}

	/*
	 * To see Data of Payment with Payment ID
	 * 
	 * @GetMapping - to handle GET(get) type of request
	 */
	@GetMapping("/getPayment/{paymentId}")
	public ResponseEntity<Map<String, Object>> getPayment(@PathVariable("paymentId") Long paymentId)
			throws PaymentNotFoundException {
		Map<String, Object> paym = new HashMap<>();
		paym.put(status, true);
		paym.put(message, "Payment with Id!");
		paym.put("data", paymentService.getPayment(paymentId));
		return new ResponseEntity<>(paym, HttpStatus.OK);
	}
}